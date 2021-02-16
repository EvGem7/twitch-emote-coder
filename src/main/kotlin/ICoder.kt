
interface ICoder {

    fun encode(message: String): String

    fun decode(message: String): String?
}