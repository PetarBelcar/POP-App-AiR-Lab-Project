package hr.foi.air.popapp.login_username_password

import junit.framework.TestCase.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class EmailValidatorTest {

    //validate valid email – isValidEmail returns true for valid email
    @Test
    fun validEmail_isCorrect() {
        val validEmail = "test@example.com"
        assertTrue(isValidEmail(validEmail))
    }

    //validate invalid email - isValidEmail returns fals for invalid email
    @Test
    fun invalidEmail_isCorrect() {
        val invalidEmail = "invalid.email"
        assertFalse(isValidEmail(invalidEmail))
    }

    //validate email - returns false or true
    private fun isValidEmail(email: String): Boolean {
        val emailRegex = Regex("^[A-Za-z](.*)([@]{1})(.{1,})(\\.)(.{1,})")
        return email.matches(emailRegex)
    }

}