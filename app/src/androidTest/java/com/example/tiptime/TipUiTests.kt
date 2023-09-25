package com.example.tiptime

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performTextInput
import com.example.tiptime.ui.theme.TipTimeTheme
import com.example.tiptime.view.TipTimeLayout
import org.junit.Rule
import org.junit.Test
import java.text.NumberFormat

class TipUiTests {
    @get:Rule
    val composeTestRule = createComposeRule()
    /*
    Instrumentation tests test an actual instance of the app and its UI,
    so the UI content must be set, similar to how the content is set in
    the onCreate() method of the MainActivity.kt file when you wrote the
    code for the Tip Time app. You need to do this before you write all
    instrumentation tests for apps built with Compose.

    In the case of the Tip Time app tests, you proceed to write instructions
    to interact with the UI components so that the tip calculating process
    is tested through the UI. The concept of an instrumentation test can
    seem abstract at first, but don't worry! The process is covered in the following steps.

    Write the test:

    Create a composeTestRule variable set to the result of the createComposeRule()
    method and annotate it with the Rule annotation:

    Create a calculate_20_percent_tip() method and annotate it with the
    @Test annotation. The compiler knows that methods annotated with @Test annotation
    in the androidTest directory refer to instrumentation tests and
    methods annotated with @Test annotation in the test directory
    refer to local tests.

    In the function body, call the composeTestRule.setContent() function.
    This sets the UI content of the composeTestRule.

    In the function's lambda body, call the TipTimeTheme() function with a
    lambda body that calls the TipTimeLayout() function.

    UI components can be accessed as nodes through the composeTestRule.
    A common way to do this is to access a node that contains a particular
    text with the onNodeWithText() method. Use the onNodeWithText() method
    to access the TextField composable for the bill amount:

    Next you can call the performTextInput() method and pass in the text
    that you want entered to fill the TextField composable.
     */

    @Test
    fun calculate_20_percent_tip(){
      composeTestRule.setContent {
         TipTimeTheme {
             TipTimeLayout()
         }
      }

        composeTestRule.onNodeWithText("Bill Amount").performTextInput("10")
        composeTestRule.onNodeWithText("Tip Percentage").performTextInput("20")

        val expectedTip = NumberFormat.getCurrencyInstance().format(2)
        composeTestRule.onNodeWithText("Tip Amount: $expectedTip").assertExists("No node with this text was found.")
    }
}

