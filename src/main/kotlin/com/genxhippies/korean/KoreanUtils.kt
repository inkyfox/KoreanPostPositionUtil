@file:JvmName("KoUtils")
package com.genxhippies.korean

private val predefinedPronounciations: Map<String, String> = mapOf(
    "null" to "널"
)

private enum class 종성종류 {
    있음, 없음, 모름;

    companion object {
        fun 기본_종성(c: Char): 종성종류 = when (c) {
            in '가'..'힇' -> if ((c.toInt() - 0xAC00) % 28 > 0) 종성종류.있음 else 종성종류.없음
            in "136780;" -> 종성종류.있음
            in "2459aeiouwy\"'-!?" -> 종성종류.없음
            else -> 종성종류.모름
        }

        fun 리을_아닌_종성(c: Char): 종성종류 = when (c) {
            in '가'..'힇' -> ((c.toInt() - 0xAC00) % 28).let { if (it != 0 && it != 8) 종성종류.있음 else 종성종류.없음 }
            in "360;" -> 종성종류.있음
            in "1245789aeiouwy\"'-!?" -> 종성종류.없음
            else -> 종성종류.모름
        }
    }
}

private enum class 조사(
        val 종성_있는_조사: String,
        val 종성_없는_조사: String,
        val 알_수_없을_때의_조사: String,
        val 종성_검사기: (Char) -> 종성종류
) {
    은는("은", "는", "은(는)", 종성종류.Companion::기본_종성),
    이가("이", "가", "이(가)", 종성종류.Companion::기본_종성),
    을를("을", "를", "을(를)", 종성종류.Companion::기본_종성),
    과와("과", "와", "과(와)", 종성종류.Companion::기본_종성),

    으로("으로", "로", "(으)로", 종성종류.Companion::리을_아닌_종성),

    이여("이여", "여", "(이)여", 종성종류.Companion::기본_종성),

    _이("이", "", "(이)", 종성종류.Companion::기본_종성);

    fun of(letter: Char): String = when (종성_검사기(letter)) {
        종성종류.있음 -> 종성_있는_조사
        종성종류.없음 -> 종성_없는_조사
        종성종류.모름 -> 알_수_없을_때의_조사
    }
}

private fun String.lastLetter(): Char? =
        trim().let { predefinedPronounciations.getOrDefault(it, it) }.run {
            lastOrNull()?.let {c ->
                when (c) {
                    in "\"';-!?" -> substring(0, lastIndex).trim().lastOrNull() ?: c
                    ')' ->
                        lastIndexOf('(').let {
                        when {
                            it >= 0 ->
                                if (endsWith("(이)")) '이'
                                else {
                                    substringBeforeLast("(").trim().lastOrNull()
                                            ?: substring(it + 1, lastIndex).trim().lastOrNull()
                                            ?: c
                                }
                            else -> substring(0, lastIndex).trim().lastOrNull() ?: c
                        }
                    }
                    else -> c
                }
            }
        }

private infix fun String.append(조사: 조사): String =
        lastLetter()?.let { this + 조사.of(it) } ?: "[$this]${조사.종성_있는_조사}"

val Any?.은는 @JvmName("은는") get() = toString().append(조사.은는)
val Any?.이가 @JvmName("이가") get() = toString().append(조사.이가)
val Any?.을를 @JvmName("을를") get() = toString().append(조사.을를)
val Any?.과와 @JvmName("과와") get() = toString().append(조사.과와)
val Any?.으로 @JvmName("으로") get() = toString().append(조사.으로)
val Any?.이여 @JvmName("이여") get() = toString().append(조사.이여)

val Any?._이 @JvmName("_이") get() = toString().append(조사._이)

val Any?.은 get() = 은는
val Any?.는 get() = 은는
val Any?.이 get() = 이가
val Any?.가 get() = 이가
val Any?.을 get() = 을를
val Any?.를 get() = 을를
val Any?.과 get() = 과와
val Any?.와 get() = 과와
val Any?.로 get() = 으로
val Any?.여 get() = 이여
val Any?.`(이)` get() = _이
