package com.example.testingapp.views.views

import android.content.ContentValues.TAG
import android.os.Bundle
import android.preference.PreferenceManager
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.testingapp.databinding.ActivityMainBinding
import com.example.testingapp.views.views.model.SharedPreferenceEntry
import com.example.testingapp.views.views.util.EmailValidator
import com.example.testingapp.views.views.util.SharedPreferencesHelper
import java.util.*


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var emailValidator: EmailValidator

    private var mSharedPreferencesHelper: SharedPreferencesHelper? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        val view: View = binding.root
        setContentView(view)

        //setup field validators
         emailValidator= EmailValidator()

        // Instantiate a SharedPreferencesHelper.
        // Instantiate a SharedPreferencesHelper.
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
        mSharedPreferencesHelper = SharedPreferencesHelper(sharedPreferences)

        populateUI()
        binding.saveButton.setOnClickListener {
            onSaveClick()
        }

    }


    private fun populateUI(){
        val sharedPreferenceEntry:SharedPreferenceEntry = mSharedPreferencesHelper!!.personalInfo
        binding.userNameInput.setText(sharedPreferenceEntry.name)
        val dateOfBirth:Calendar= sharedPreferenceEntry.dob
        binding.dateOfBirthInput.init(dateOfBirth.get(Calendar.YEAR),
            dateOfBirth.get(Calendar.MONTH),
            dateOfBirth.get(Calendar.DAY_OF_MONTH),null)
        binding.emailInput.setText(sharedPreferenceEntry.email)
    }


    public fun onSaveClick(){
        // Don't save if the fields do not validate.
        // Don't save if the fields do not validate.
        if (!emailValidator.isValid) {
            binding.emailInput.setError("Invalid email")
            Log.w(TAG, "Not saving personal information: Invalid email")
            return
        }

        // Get the text from the input fields.

        // Get the text from the input fields.
        val name: String = binding.userNameInput.getText().toString()
        val dateOfBirth = Calendar.getInstance()
        dateOfBirth[binding.dateOfBirthInput.getYear(), binding.dateOfBirthInput.getMonth()] = binding.dateOfBirthInput.getDayOfMonth()
        val email: String = binding.emailInput.getText().toString()

        // Create a Setting model class to persist.

        // Create a Setting model class to persist.
        val sharedPreferenceEntry = SharedPreferenceEntry(name, dateOfBirth, email)

        // Persist the personal information.

        // Persist the personal information.
        val isSuccess = mSharedPreferencesHelper!!.savePersonalInfo(sharedPreferenceEntry)
        if (isSuccess) {
            Toast.makeText(this, "Personal information saved", Toast.LENGTH_LONG).show()
            Log.i(TAG, "Personal information saved")
        } else {
            Log.e(TAG, "Failed to write personal information to SharedPreferences")
        }
    }


    public fun onRevertClick(view:View){
        populateUI()
        Toast.makeText(this,"Personal information reverted",Toast.LENGTH_SHORT).show()
        Log.i(TAG, "Personal information reverted");

    }
}