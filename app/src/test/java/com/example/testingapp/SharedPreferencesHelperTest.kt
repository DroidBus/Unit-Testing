package com.example.testingapp

import android.content.SharedPreferences
import com.example.testingapp.views.views.model.SharedPreferenceEntry
import com.example.testingapp.views.views.util.SharedPreferencesHelper
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Test
import org.mockito.Matchers.*
import org.mockito.Mock
import org.mockito.Mockito.`when`
import java.util.*


class SharedPreferencesHelperTest {

    private val TEST_NAME = "Test name"

    private val TEST_EMAIL = "test@email.com"

    private val TEST_DATE_OF_BIRTH: Calendar = Calendar.getInstance()

    init {
        TEST_DATE_OF_BIRTH.set(1980, 1, 1)
    }


    private var mSharedPreferenceEntry: SharedPreferenceEntry? = null

    private var mMockSharedPreferencesHelper: SharedPreferencesHelper? = null

    private var mMockBrokenSharedPreferencesHelper: SharedPreferencesHelper? = null

    @Mock
    var mMockSharedPreferences: SharedPreferences? = null

    @Mock
    var mMockBrokenSharedPreferences: SharedPreferences? = null

    @Mock
    var mMockEditor: SharedPreferences.Editor? = null

    @Mock
    var mMockBrokenEditor: SharedPreferences.Editor? = null

    @Before
    fun initMocks() {
        // Create SharedPreferenceEntry to persist.
        mSharedPreferenceEntry = SharedPreferenceEntry(
            TEST_NAME, TEST_DATE_OF_BIRTH,
            TEST_EMAIL
        )

        // Create a mocked SharedPreferences.
        mMockSharedPreferencesHelper = createMockSharedPreference()

        // Create a mocked SharedPreferences that fails at saving data.
        mMockBrokenSharedPreferencesHelper = createBrokenMockSharedPreference()
    }

    @Test
    fun sharedPreferencesHelper_SaveAndReadPersonalInformation() {
        // Save the personal information to SharedPreferences
        val success = mMockSharedPreferencesHelper!!.savePersonalInfo(mSharedPreferenceEntry!!)
        assertThat(
            "Checking that SharedPreferenceEntry.save... returns true",
            success, `is`(true)
        )

        // Read personal information from SharedPreferences
        val savedSharedPreferenceEntry = mMockSharedPreferencesHelper!!.personalInfo

        // Make sure both written and retrieved personal information are equal.
        assertThat(
            "Checking that SharedPreferenceEntry.name has been persisted and read correctly",
            mSharedPreferenceEntry!!.name,
            `is`(equalTo(savedSharedPreferenceEntry.name))
        )
        assertThat(
            "Checking that SharedPreferenceEntry.dateOfBirth has been persisted and read "
                    + "correctly",
            mSharedPreferenceEntry!!.dob,
            `is`(equalTo(savedSharedPreferenceEntry.dob))
        )
        assertThat(
            ("Checking that SharedPreferenceEntry.email has been persisted and read "
                    + "correctly"),
            mSharedPreferenceEntry!!.email,
            `is`(equalTo(savedSharedPreferenceEntry.email))
        )
    }

    @Test
    fun sharedPreferencesHelper_SavePersonalInformationFailed_ReturnsFalse() {
        // Read personal information from a broken SharedPreferencesHelper
        val success =
            mMockBrokenSharedPreferencesHelper!!.savePersonalInfo((mSharedPreferenceEntry)!!)
        assertThat(
            "Makes sure writing to a broken SharedPreferencesHelper returns false", success,
            `is`(false)
        )
    }

    /**
     * Creates a mocked SharedPreferences.
     */
    private fun createMockSharedPreference(): SharedPreferencesHelper? {
        // Mocking reading the SharedPreferences as if mMockSharedPreferences was previously written
        // correctly.
        `when`(
            mMockSharedPreferences!!.getString(
                eq(SharedPreferencesHelper.KEY_NAME),
                anyString()
            )
        )
            .thenReturn(mSharedPreferenceEntry!!.name)
        `when`(
            mMockSharedPreferences!!.getString(
                eq(SharedPreferencesHelper.KEY_EMAIL),
                anyString()
            )
        )
            .thenReturn(mSharedPreferenceEntry!!.email)
        `when`(mMockSharedPreferences!!.getLong(eq(SharedPreferencesHelper.KEY_DOB), anyLong()))
            .thenReturn(mSharedPreferenceEntry!!.dob.getTimeInMillis())

        // Mocking a successful commit.
        `when`(mMockEditor!!.commit()).thenReturn(true)

        // Return the MockEditor when requesting it.
        `when`(mMockSharedPreferences!!.edit()).thenReturn(mMockEditor)
        return SharedPreferencesHelper((mMockSharedPreferences)!!)
    }

    /**
     * Creates a mocked SharedPreferences that fails when writing.
     */
    private fun createBrokenMockSharedPreference(): SharedPreferencesHelper? {
        // Mocking a commit that fails.
        `when`(mMockBrokenEditor!!.commit()).thenReturn(false)

        // Return the broken MockEditor when requesting it.
        `when`(mMockBrokenSharedPreferences!!.edit()).thenReturn(mMockBrokenEditor)
        return SharedPreferencesHelper((mMockBrokenSharedPreferences)!!)
    }
}