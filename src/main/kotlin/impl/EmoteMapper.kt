package impl

object EmoteMapper {

    private val list = listOf(
        "TPFufun",
        "LUL",
        "Squid4",
        "Squid3",
        "Squid2",
        "Squid1",
        "TehePelo",
        "PunOko",
        "KonCha",
        "CoolStoryBob",
        "TriHard",
        "Poooound",
        "Jebaited",
        "cmonBruh",
        "OhMyDog",
        "OSFrog",
        "SeriousSloth",
        "KomodoHype",
        "SeemsGood",
        "riPepperonis",
        "NotLikeThis",
        "DendiFace",
        "CoolCat",
        "KappaPride",
        "mcaT",
        "HeyGuys",
        "WutFace",
        "BabyRage",
        "EleGiggle",
        "BrokeBack",
        "ANELE",
        "4Head",
        "ResidentSleeper",
        "BibleThump",
        "BloodTrail",
        "FrankerZ",
        "SMOrc",
        "Kreygasm",
        "MrDestructoid",
        "Kappa",
        "FailFish",
    )

    private val map = kotlin.run {
        val hashMap = HashMap<String, Int>(list.size + 1)
        list.forEachIndexed { index, emote ->
            hashMap[emote] = index
        }
        hashMap
    }

    fun getEmote(number: Int): String {
        return list[number]
    }

    fun getNumber(emote: String): Int? {
        return map[emote]
    }

    fun getEmoteSystemBase(): Int = list.size
}