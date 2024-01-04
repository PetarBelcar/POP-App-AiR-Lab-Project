package hr.foi.air.popapp.ws

import androidx.test.ext.junit.runners.AndroidJUnit4
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import okhttp3.Request

@RunWith(AndroidJUnit4::class)
class RegisterServiceTest {

    private lateinit var mockWebServer: MockWebServer

    @Test
    fun test() {
        mockWebServer = MockWebServer()

        mockWebServer.enqueue(
            MockResponse().setResponseCode(200).setBody("Could not register user!")
        )

        mockWebServer.start()

        val baseUrl = mockWebServer.url("/register")

        val jsonForExistingUser = "{\n" +
                "    \"first_name\": \"SomeName\",\n" +
                "    \"last_name\": \"SomeSurname\",\n" +
                "    \"username\": \"cvelasquez\",\n" +
                "    \"email\": \"someemail@ase.foi.hr\",\n" +
                "    \"password\": \"test123\",\n" +
                "    \"role\": \"buyer\"\n" +
                "}"

        val client = OkHttpClient()

        val requestBody = jsonForExistingUser.toRequestBody("application/json".toMediaType())

        val request = Request.Builder().url(baseUrl).post(requestBody).build()
        val response = client.newCall(request).execute()

        Assert.assertTrue(response.code == 200)

        response.body.also { res ->
            val stringResponseBody = res?.string()!!
            Assert.assertTrue(stringResponseBody.contains("Could not register user!"))
        }
    }
}