package care.ai.play2paycodingchallenge

import care.ai.play2paycodingchallenge.models.EbayItem
import org.junit.Assert.assertEquals
import org.junit.Test

class ModelTest {

    val testModel:EbayItem = EbayItem("Test", "Author", "http://someurl")

    @Test
    fun testModel(){
        assertEquals(testModel.title, "Test")
    }
}