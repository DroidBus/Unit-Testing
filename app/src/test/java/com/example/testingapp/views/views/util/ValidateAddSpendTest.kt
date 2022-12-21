package com.example.testingapp.views.views.util

import com.google.common.truth.Truth.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4


@RunWith(JUnit4::class)
class ValidateAddSpendTest{

     @Test
     fun whenInputGivenIsValid(){
         val amount=2000
         val desc= "Some random description"
         val result = ValidateAddSpend.validateAddSpend(amount,desc)

         assertThat(result).isEqualTo(true)
     }


}