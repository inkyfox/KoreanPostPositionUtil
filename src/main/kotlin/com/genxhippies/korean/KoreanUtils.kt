@file:JvmName("KoreanUtils")
package com.genxhippies.korean

private fun String?.종성_유무(종성_있는_조사: String, 종성_없는_조사: String): String =
        if (this == null) "${toString()}$종성_있는_조사"
        else this + lastOrNull().let {
            when (it) {
                null -> "''$종성_있는_조사"
                in '가'..'힇' -> if ((it.toInt() - 0xAC00) % 28 > 0) 종성_있는_조사 else 종성_없는_조사
                in "136780" -> 종성_있는_조사
                in "2459aeiouwy" -> 종성_없는_조사
                else -> "$종성_있는_조사($종성_없는_조사)"
            }
        }

private val 종성이_없거나_리을_값 = listOf(0, 8)

private fun String?.종성이_없거나_리을(종성_있는_조사: String, 종성_없는_조사: String): String =
        if (this == null) "${toString()}$종성_없는_조사"
        else this + lastOrNull().let {
            when (it) {
                null -> "''$종성_있는_조사"
                in '가'..'힇' -> if ((it.toInt() - 0xAC00) % 28 in 종성이_없거나_리을_값) 종성_없는_조사 else 종성_있는_조사
                in "360" -> 종성_있는_조사
                in "1245789aeiouwy" -> 종성_없는_조사
                else -> "$종성_있는_조사($종성_없는_조사)"
            }
        }

val String?.은는 @JvmName("은는") get() = 종성_유무("은", "는")
val String?.이가 @JvmName("이가") get() = 종성_유무("이", "가")
val String?.이가_가 @JvmName("이가_가") get() = 종성_유무("이가", "가")
val String?.을를 @JvmName("을를") get() = 종성_유무("을", "를")
val String?.과와 @JvmName("과와") get() = 종성_유무("과", "와")
val String?.이여 @JvmName("이여") get() = 종성_유무("이여", "여")
val String?.으로_로 @JvmName("으로_로") get() = 종성이_없거나_리을("으로", "로")

val String?.는은 @JvmName("는은") get() = 은는
val String?.는 @JvmName("는") get() = 은는
val String?.은 @JvmName("은") get() = 은는

val String?.가이 @JvmName("가이") get() = 이가
val String?.가 @JvmName("가") get() = 이가
val String?.이 @JvmName("이") get() = 이가

val String?.를을 @JvmName("를을") get() = 을를
val String?.를 @JvmName("를") get() = 을를
val String?.을 @JvmName("을") get() = 을를

val String?.와과 @JvmName("와과") get() = 과와
val String?.와 @JvmName("와") get() = 과와
val String?.과 @JvmName("과") get() = 과와

val String?.으로 @JvmName("으로") get() = 으로_로
val String?.로 @JvmName("로") get() = 으로_로
