package com.genxhippies.korean;

import org.junit.Assert;
import org.junit.Test;

public class JavaTest {

    @Test
    public void 종성_없는_한글() {
        Assert.assertEquals("용하는", KoUtils.은는("용하"));
        Assert.assertEquals("용하가", KoUtils.이가("용하"));
        Assert.assertEquals("용하가", KoUtils.이가_가("용하"));
        Assert.assertEquals("용하를", KoUtils.을를("용하"));
        Assert.assertEquals("용하와", KoUtils.과와("용하"));
        Assert.assertEquals("용하여", KoUtils.이여("용하"));
        Assert.assertEquals("용하는", KoUtils.이는("용하"));
    }

    @Test
    public void 종성_있는_한글() {
        Assert.assertEquals("소율은", KoUtils.은는("소율"));
        Assert.assertEquals("소율이", KoUtils.이가("소율"));
        Assert.assertEquals("소율이가", KoUtils.이가_가("소율"));
        Assert.assertEquals("소율을", KoUtils.을를("소율"));
        Assert.assertEquals("소율과", KoUtils.과와("소율"));
        Assert.assertEquals("소율이여", KoUtils.이여("소율"));
        Assert.assertEquals("소율이는", KoUtils.이는("소율"));
    }

    @Test
    public void 종성_없는_영문() {
        Assert.assertEquals("Yongha는", KoUtils.은는("Yongha"));
        Assert.assertEquals("Yongha가", KoUtils.이가("Yongha"));
        Assert.assertEquals("Yongha가", KoUtils.이가_가("Yongha"));
        Assert.assertEquals("Yongha를", KoUtils.을를("Yongha"));
        Assert.assertEquals("Yongha와", KoUtils.과와("Yongha"));
        Assert.assertEquals("Yongha여", KoUtils.이여("Yongha"));
        Assert.assertEquals("Yongha로", KoUtils.으로("Yongha"));
    }

    @Test
    public void 종성_없는_숫자() {
        Assert.assertEquals("12는", KoUtils.은는("12"));
        Assert.assertEquals("12가", KoUtils.이가("12"));
        Assert.assertEquals("12를", KoUtils.을를("12"));
        Assert.assertEquals("12와", KoUtils.과와("12"));
    }

    @Test
    public void 종성_있는_숫자() {
        Assert.assertEquals("123은", KoUtils.은는("123"));
        Assert.assertEquals("123이", KoUtils.이가("123"));
        Assert.assertEquals("123을", KoUtils.을를("123"));
        Assert.assertEquals("123과", KoUtils.과와("123"));
    }

    @Test
    public void 종성_없거나_리을인_한글() {
        Assert.assertEquals("용하로", KoUtils.으로("용하"));
        Assert.assertEquals("소율로", KoUtils.으로("소율"));
    }

    @Test
    public void 리을아닌_종성인_한글() {
        Assert.assertEquals("코틀린으로", KoUtils.으로("코틀린"));
    }

    @Test
    public void 종성_없거나_리을인_숫자() {
        Assert.assertEquals("1로", KoUtils.으로("1"));
        Assert.assertEquals("2로", KoUtils.으로("2"));
        Assert.assertEquals("4로", KoUtils.으로("4"));
        Assert.assertEquals("5로", KoUtils.으로("5"));
        Assert.assertEquals("7로", KoUtils.으로("7"));
        Assert.assertEquals("8로", KoUtils.으로("8"));
        Assert.assertEquals("9로", KoUtils.으로("9"));
    }

    @Test
    public void 리을아닌_종성인_숫자() {
        Assert.assertEquals("3으로", KoUtils.으로("3"));
        Assert.assertEquals("6으로", KoUtils.으로("6"));
        Assert.assertEquals("0으로", KoUtils.으로("0"));
        Assert.assertEquals("10으로", KoUtils.으로("10"));
    }

    @Test
    public void 빈_문자열() {
        Assert.assertEquals("[]은", KoUtils.은는(""));
        Assert.assertEquals("[]이", KoUtils.이가(""));
        Assert.assertEquals("[]을", KoUtils.을를(""));
        Assert.assertEquals("[]과", KoUtils.과와(""));
        Assert.assertEquals("[]이여", KoUtils.이여(""));
        Assert.assertEquals("[]으로", KoUtils.으로(""));

        Assert.assertEquals("[ ]은", KoUtils.은는(" "));
    }

    @Test
    public void 알_수_없는_문자열() {
        Assert.assertEquals("Soyul은(는)", KoUtils.은는("Soyul"));
        Assert.assertEquals("Soyul이(가)", KoUtils.이가("Soyul"));
        Assert.assertEquals("Soyul(이)가", KoUtils.이가_가("Soyul"));
        Assert.assertEquals("Soyul을(를)", KoUtils.을를("Soyul"));
        Assert.assertEquals("Soyul과(와)", KoUtils.과와("Soyul"));
        Assert.assertEquals("Soyul(이)여", KoUtils.이여("Soyul"));
        Assert.assertEquals("Soyul(으)로", KoUtils.으로("Soyul"));
    }

    @Test
    public void null_문자열() {
        Assert.assertEquals("null은", KoUtils.은는(null));
        Assert.assertEquals("null이", KoUtils.이가(null));
        Assert.assertEquals("null을", KoUtils.을를(null));
        Assert.assertEquals("null과", KoUtils.과와(null));
        Assert.assertEquals("null로", KoUtils.으로(null));
    }

    @Test
    public void 특수문자() {
        Assert.assertEquals("\"코틀린\"은", KoUtils.은는("\"코틀린\""));
        Assert.assertEquals("\"자바\"는", KoUtils.은는("\"자바\""));
        Assert.assertEquals("\"\"는", KoUtils.은는("\"\""));
        Assert.assertEquals("\"는", KoUtils.은는("\""));

        Assert.assertEquals("!는", KoUtils.은는("!"));
        Assert.assertEquals(";은", KoUtils.은는(";"));
    }

    @Test
    public void 괄호() {
        Assert.assertEquals("코틀린(Kotlin)은", KoUtils.은는("코틀린(Kotlin)"));
        Assert.assertEquals("자바(Java lang)는", KoUtils.은는("자바(Java lang)"));
        Assert.assertEquals("(Kotlin)은(는)", KoUtils.은는("(Kotlin)"));
    }

    @Test
    public void 숫자() {
        Assert.assertEquals("1은", KoUtils.은는(1));
        Assert.assertEquals("2는", KoUtils.은는(2));
        Assert.assertEquals("3은", KoUtils.은는(3));
        Assert.assertEquals("4는", KoUtils.은는(4));
        Assert.assertEquals("5는", KoUtils.은는(5));
        Assert.assertEquals("6은", KoUtils.은는(6));
        Assert.assertEquals("7은", KoUtils.은는(7));
        Assert.assertEquals("8은", KoUtils.은는(8));
        Assert.assertEquals("9는", KoUtils.은는(9));
        Assert.assertEquals("10은", KoUtils.은는(10));

        Assert.assertEquals("1로", KoUtils.으로(1));
        Assert.assertEquals("2로", KoUtils.으로(2));
        Assert.assertEquals("3으로", KoUtils.으로(3));
        Assert.assertEquals("4로", KoUtils.으로(4));
        Assert.assertEquals("5로", KoUtils.으로(5));
        Assert.assertEquals("6으로", KoUtils.으로(6));
        Assert.assertEquals("7로", KoUtils.으로(7));
        Assert.assertEquals("8로", KoUtils.으로(8));
        Assert.assertEquals("9로", KoUtils.으로(9));
        Assert.assertEquals("10으로", KoUtils.으로(10));
    }
}
