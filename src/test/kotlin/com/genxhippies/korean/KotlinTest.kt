package com.genxhippies.korean

import org.junit.Assert
import org.junit.Test

internal class KotlinTest {
    @Test
    fun 종성_없는_한글() {
        Assert.assertEquals("용하는", "용하".은는)
        Assert.assertEquals("용하가", "용하".이가)
        Assert.assertEquals("용하가", "용하".이가_가)
        Assert.assertEquals("용하를", "용하".을를)
        Assert.assertEquals("용하와", "용하".과와)
        Assert.assertEquals("용하여", "용하".이여)
        Assert.assertEquals("용하는", "용하".이는)
    }

    @Test
    fun 종성_있는_한글() {
        Assert.assertEquals("소율은", "소율".은는)
        Assert.assertEquals("소율이", "소율".이가)
        Assert.assertEquals("소율이가", "소율".이가_가)
        Assert.assertEquals("소율을", "소율".을를)
        Assert.assertEquals("소율과", "소율".과와)
        Assert.assertEquals("소율이여", "소율".이여)
        Assert.assertEquals("소율이는", "소율".이는)
    }

    @Test
    fun 종성_없는_영문() {
        Assert.assertEquals("Yongha는", "Yongha".은는)
        Assert.assertEquals("Yongha가", "Yongha".이가)
        Assert.assertEquals("Yongha가", "Yongha".이가_가)
        Assert.assertEquals("Yongha를", "Yongha".을를)
        Assert.assertEquals("Yongha와", "Yongha".과와)
        Assert.assertEquals("Yongha여", "Yongha".이여)
        Assert.assertEquals("Yongha로", "Yongha".으로)
    }

    @Test
    fun 종성_없는_숫자() {
        Assert.assertEquals("12는", "12".은는)
        Assert.assertEquals("12가", "12".이가)
        Assert.assertEquals("12를", "12".을를)
        Assert.assertEquals("12와", "12".과와)
    }

    @Test
    fun 종성_있는_숫자() {
        Assert.assertEquals("123은", "123".은는)
        Assert.assertEquals("123이", "123".이가)
        Assert.assertEquals("123을", "123".을를)
        Assert.assertEquals("123과", "123".과와)
    }

    @Test
    fun 종성_없거나_리을인_한글() {
        Assert.assertEquals("용하로", "용하".으로)
        Assert.assertEquals("소율로", "소율".으로)
    }

    @Test
    fun 리을아닌_종성인_한글() {
        Assert.assertEquals("코틀린으로", "코틀린".으로)
    }

    @Test
    fun 종성_없거나_리을인_숫자() {
        Assert.assertEquals("1로", "1".으로)
        Assert.assertEquals("2로", "2".으로)
        Assert.assertEquals("4로", "4".으로)
        Assert.assertEquals("5로", "5".으로)
        Assert.assertEquals("7로", "7".으로)
        Assert.assertEquals("8로", "8".으로)
        Assert.assertEquals("9로", "9".으로)
    }

    @Test
    fun 리을아닌_종성인_숫자() {
        Assert.assertEquals("3으로", "3".으로)
        Assert.assertEquals("6으로", "6".으로)
        Assert.assertEquals("0으로", "0".으로)
        Assert.assertEquals("10으로", "10".으로)
    }

    @Test
    fun 빈_문자열() {
        Assert.assertEquals("[]은", "".은는)
        Assert.assertEquals("[]이", "".이가)
        Assert.assertEquals("[]을", "".을를)
        Assert.assertEquals("[]과", "".과와)
        Assert.assertEquals("[]이여", "".이여)
        Assert.assertEquals("[]으로", "".으로)

        Assert.assertEquals("[ ]은", " ".은는)
    }
    
    @Test
    fun 알_수_없는_문자열() {
        Assert.assertEquals("Soyul은(는)", "Soyul".은는)
        Assert.assertEquals("Soyul이(가)", "Soyul".이가)
        Assert.assertEquals("Soyul(이)가", "Soyul".이가_가)
        Assert.assertEquals("Soyul을(를)", "Soyul".을를)
        Assert.assertEquals("Soyul과(와)", "Soyul".과와)
        Assert.assertEquals("Soyul(이)여", "Soyul".이여)
        Assert.assertEquals("Soyul(으)로", "Soyul".으로)
    }

    @Test
    fun null_문자열() {
        Assert.assertEquals("null은", null.은는)
        Assert.assertEquals("null이", null.이가)
        Assert.assertEquals("null을", null.을를)
        Assert.assertEquals("null과", null.과와)
        Assert.assertEquals("null로", null.으로)
    }

    @Test
    fun 특수문자() {
        Assert.assertEquals("\"코틀린\"은", "\"코틀린\"".은는)
        Assert.assertEquals("\"자바\"는", "\"자바\"".은는)
        Assert.assertEquals("\"\"는", "\"\"".은는)
        Assert.assertEquals("\"는", "\"".은는)

        Assert.assertEquals("!는", "!".은는)
        Assert.assertEquals(";은", ";".은는)
    }

    @Test
    fun 괄호() {
        Assert.assertEquals("코틀린(Kotlin)은", "코틀린(Kotlin)".은는)
        Assert.assertEquals("자바(Java lang)는", "자바(Java lang)".은는)
        Assert.assertEquals("(Kotlin)은(는)", "(Kotlin)".은는)
    }

    @Test
    fun 숫자() {
        Assert.assertEquals("1은", 1.은는)
        Assert.assertEquals("2는", 2.은는)
        Assert.assertEquals("3은", 3.은는)
        Assert.assertEquals("4는", 4.은는)
        Assert.assertEquals("5는", 5.은는)
        Assert.assertEquals("6은", 6.은는)
        Assert.assertEquals("7은", 7.은는)
        Assert.assertEquals("8은", 8.은는)
        Assert.assertEquals("9는", 9.은는)
        Assert.assertEquals("10은", 10.은는)

        Assert.assertEquals("1로", 1.으로)
        Assert.assertEquals("2로", 2.으로)
        Assert.assertEquals("3으로", 3.으로)
        Assert.assertEquals("4로", 4.으로)
        Assert.assertEquals("5로", 5.으로)
        Assert.assertEquals("6으로", 6.으로)
        Assert.assertEquals("7로", 7.으로)
        Assert.assertEquals("8로", 8.으로)
        Assert.assertEquals("9로", 9.으로)
        Assert.assertEquals("10으로", 10.으로)
    }
}
