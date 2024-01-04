package hr.foi.air.popapp.login_username_password

import org.junit.Assert.assertArrayEquals
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import java.text.SimpleDateFormat
import java.util.Date

class MyFirstUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun addition_isNotCorrect() {
        assertNotEquals(4, 2 + 5)
    }

    @Test
    fun checkDate() {
        val sdf = SimpleDateFormat("dd/MM/yyyy")
        val currentDate = sdf.format(Date())
        val date = "07/12/2023"
        assertNotEquals(currentDate, date);
    }

    @Test
    fun checkList() {
        val list = listOf("a1", "a2")
        assertTrue(list.contains("a1"))
    }

    @Test
    fun checkListSize() {
        val list = listOf("a1", "a2")
        assertEquals(2, list.size)
    }

    @Test
    fun checkArray() {
        val arr : IntArray = intArrayOf(10, 20, 30, 40, 50)
        assertArrayEquals(intArrayOf(10, 20, 30, 40, 50), arr)
    }


}