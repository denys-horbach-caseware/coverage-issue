import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

class TestAppWithoutFullCoverage(private val parameters: Map<String, String>) {

  fun call() {
    val catalogDatabase = parameters["catalogDatabase"]
    if (catalogDatabase == null)
      missingParameter("catalogDatabase")
    val s = parameters["outputs"]
    Json.decodeFromString<Outputs>(
      if (s != null) s
      else
        missingParameter("outputs")
    )
  }
}
