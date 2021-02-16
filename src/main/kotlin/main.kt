import impl.CoderImpl
import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val coder: ICoder = CoderImpl()
    while (true) {
        val next = scanner.nextLine()
        if (next.startsWith("e ")) {
            val emotes = coder.encode(next.drop(2))
            println(emotes)
        } else if (next.startsWith("d ")) {
            val message = coder.decode(next.drop(2))
            println(message)
        }
    }
}