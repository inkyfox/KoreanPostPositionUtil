package com.genxhippies

fun String?.postPosition(종성_있는_조사: String, 종성_없는_조사: String): String =
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

val String?.은는 get() = postPosition("은", "는")
val String?.이가 get() = postPosition("이", "가")
val String?.이가_가 get() = postPosition("이가", "가")
val String?.을를 get() = postPosition("을", "를")
val String?.과와 get() = postPosition("과", "와")
val String?.이여 get() = postPosition("이여", "여")


val String?.는은 get() = 은는
val String?.가이 get() = 이가
val String?.를을 get() = 을를
val String?.와과 get() = 과와
