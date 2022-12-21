package com.example.testingapp

import com.example.testingapp.views.views.util.PriceCalculator
import junit.framework.Assert.assertEquals
import org.junit.Test

class PriceCalculatorUnitTest {

    private val priceCalculator=PriceCalculator()

    @Test
    fun `Assert product final price`(){
        val expectedProductPrice = 1.5
        val finalProductPrice = priceCalculator.finalPrice(basePrice = 1.0)

        assertEquals(
            expectedProductPrice,
            finalProductPrice,
            0.001
        )
    }


}