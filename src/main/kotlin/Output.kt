import kotlinx.serialization.Serializable
@Serializable
data class Outputs(
  val outputs: List<Output>
)

@Serializable
data class Output(
  val parquetPath: String,
  val hiveTableName: String
)
