
import TestAppWithFullCoverage
import io.mockk.junit5.MockKExtension
import kotlinx.serialization.SerializationException
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.extension.ExtendWith
import kotlin.test.assertEquals

@ExtendWith(MockKExtension::class)
internal class TestAppWithFullCoverageTests {

    @Test
    fun `test app fails if catalogDatabase is missing`() {
        // arrange
        val parameters = mapOf(
            "outputs" to "outputs_json"
        )
        val testAppWithFullCoverage = TestAppWithFullCoverage(parameters)

        // act
        val ex = assertThrows<IllegalStateException> { testAppWithFullCoverage.call() }

        // assert
        assertEquals("Parameter catalogDatabase is missing, but is required.", ex.message)
    }

    @Test
    fun `test app fails if output is missing`() {
        // arrange
        val parameters = mapOf(
            "catalogDatabase" to "catalog_database"
        )
        val testAppWithFullCoverage = TestAppWithFullCoverage(parameters)

        // act
        val ex = assertThrows<IllegalStateException> { testAppWithFullCoverage.call() }

        // assert
        assertEquals("Parameter outputs is missing, but is required.", ex.message)
    }

    @Test
    fun `test app fails if output is not a json`() {
        // arrange
        val parameters = mapOf(
            "catalogDatabase" to "catalog_database",
            "outputs" to "invalid_json"
        )
        val testAppWithFullCoverage = TestAppWithFullCoverage(parameters)

        // act & assert
        assertThrows<SerializationException> { testAppWithFullCoverage.call() }
    }
}

