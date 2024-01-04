package hr.foi.air.popapp

import androidx.compose.ui.test.assertAll
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onAllNodesWithTag
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.onRoot
import androidx.compose.ui.test.onSiblings
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.compose.ui.test.printToLog
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LoginInstrumentedTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    //check login - invalid username and password
    @Test
    fun loginFailure() {

        //click on login button
        composeTestRule.onNodeWithText("Login").performClick()

        //invalid username and password
        val invalidUsername = "invalidUser"
        val invalidPassword = "invalidPassword"

        composeTestRule.onNodeWithText("Username").performTextInput(invalidUsername)
        composeTestRule.onNodeWithText("Password").performTextInput(invalidPassword)

        //click on login button
        composeTestRule.onNodeWithText("Login").performClick()

        //check if error message is displayed
        composeTestRule.onNodeWithTag("errorMessage").onSiblings().assertAll(hasText("Please check your credentials!"))

    }

}