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

/**
 * "은", "는" 조사를 붙인다.
 *
 * @return 명사의 종성이 있으면 "은", 없으면 "는", 알 수 없으면 "은(는)" 문자열이 추가된 문자열
 */
val Any?.은는 @JvmName("은는") get() = toString().append(조사.은는)

/**
 * "이", "가" 조사를 붙인다.
 *
 * @return 명사의 종성이 있으면 "이", 없으면 "가", 알 수 없으면 "은(는)" 문자열이 추가된 문자열
 */
val Any?.이가 @JvmName("이가") get() = toString().append(조사.이가)

/**
 * "을", "를" 조사를 붙인다.
 *
 * @return 명사의 종성이 있으면 "을", 없으면 "를", 알 수 없으면 "을(를)" 문자열이 추가된 문자열
 */
val Any?.을를 @JvmName("을를") get() = toString().append(조사.을를)

/**
 * "과", "와" 조사를 붙인다.
 *
 * @return 명사의 종성이 있으면 "과", 없으면 "와", 알 수 없으면 "과(와)" 문자열이 추가된 문자열
 */
val Any?.과와 @JvmName("과와") get() = toString().append(조사.과와)

/**
 * "으로", "로" 조사를 붙인다.
 *
 * @return 명사의 'ㄹ'이 아닌 종성이 있으면 "으로", 없거나 'ㄹ'이면 "로", 알 수 없으면 "(으)로" 문자열이 추가된 문자열
 */
val Any?.으로 @JvmName("으로") get() = toString().append(조사.으로)

/**
 * "이여", "여" 조사를 붙인다.
 *
 * @return 명사의 종성이 있으면 "이여", 없으면 "여", 알 수 없으면 "(이)여" 문자열이 추가된 문자열
 */
val Any?.이여 @JvmName("이여") get() = toString().append(조사.이여)

/**
 * 친근함을 표시하는 목적으로 이름의 뒤에 "이"를 붙인다.
 *
 * @return 명사의 종성이 있으면 "이", 없으면 빈 문자열, 알 수 없으면 "(이)" 문자열이 추가된 문자열
 */
val Any?._이 @JvmName("_이") get() = toString().append(조사._이)

/**
 * `은는`과 같다.
 *
 * @See 은는
 */
val Any?.은 @JvmName("은") get() = 은는

/**
 * `은는`과 같다.
 *
 * @See 은는
 */
val Any?.는 @JvmName("는") get() = 은는

/**
 * `이가`과 같다.
 *
 * @See 이가
 */
val Any?.이 @JvmName("이") get() = 이가

/**
 * `이가`과 같다.
 *
 * @See 이가
 */
val Any?.가 @JvmName("가") get() = 이가

/**
 * `을를`과 같다.
 *
 * @See 을를
 */
val Any?.을 @JvmName("을") get() = 을를

/**
 * `을를`과 같다.
 *
 * @See 을를
 */
val Any?.를 @JvmName("를") get() = 을를

/**
 * `과와`과 같다.
 *
 * @See 과와
 */
val Any?.과 @JvmName("과") get() = 과와

/**
 * `과와`과 같다.
 *
 * @See 과와
 */
val Any?.와 @JvmName("와") get() = 과와

/**
 * `으로`과 같다.
 *
 * @See 으로
 */
val Any?.로 @JvmName("로") get() = 으로

/**
 * `이여`과 같다.
 *
 * @See 이여
 */
val Any?.여 @JvmName("여") get() = 이여

/**
 * `_이`과 같다.
 *
 * @See _이
 */
val Any?.`(이)` @JvmName("_이_") get() = _이
