import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

class TestAppWithFullCoverage(private val parameters: Map<String, String>) {

  fun call() {
    val catalogDatabase = parameters["catalogDatabase"]
    if (catalogDatabase == null)
      error("Parameter catalogDatabase is missing, but is required.")
    val s = parameters["outputs"]
    Json.decodeFromString<Outputs>(
      if (s != null) s
      else
        error("Parameter outputs is missing, but is required.")
    )
  }
}
