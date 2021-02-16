package impl

import ICoder
import java.lang.StringBuilder
import kotlin.math.ceil
import kotlin.math.log2
import kotlin.math.pow

class CoderImpl : ICoder {

    init {
        println("emotes count for one char: ${getEmotesCount()}")
    }

    override fun encode(message: String): String {
        val builder = StringBuilder()
        message.forEach {
            builder.apply {
                append(getEmotes(it))
            }
        }
        return builder.toString()
    }

    override fun decode(message: String): String? {
        val emotes = message.split(Regex("\\s+"))
        if (emotes.size % getEmotesCount() != 0) {
            return null
        }

        val builder = StringBuilder()
        val iterator = emotes.iterator()
        val base = EmoteMapper.getEmoteSystemBase().toFloat()
        while (iterator.hasNext()) {
            var num = 0
            repeat(getEmotesCount()) {
                val emote = iterator.next()
                num += base.pow(it).toInt() * (EmoteMapper.getNumber(emote) ?: return null)
            }
            builder.append(num.toChar())
        }
        return builder.toString()
    }

    private fun getEmotes(char: Char): String {
        val base = EmoteMapper.getEmoteSystemBase()
        var v = char.toInt()
        val builder = StringBuilder()
        repeat(getEmotesCount()) {
            val num = v % base
            v /= base
            builder.apply {
                append(EmoteMapper.getEmote(num))
                append(' ')
            }
        }
        return builder.toString()
    }

    private fun getEmotesCount(): Int {
        val base = EmoteMapper.getEmoteSystemBase().toFloat()
        return ceil(Char.SIZE_BITS / log2(base)).toInt()
    }
}
