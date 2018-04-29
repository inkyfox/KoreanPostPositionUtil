package com.genxhippies.korean;

import org.junit.Assert;
import org.junit.Test;

public class JavaTest {

    @Test
    public void 종성_없는_한글() {
        Assert.assertEquals("용하는", KoreanUtils.은는("용하"));
        Assert.assertEquals("용하가", KoreanUtils.이가("용하"));
        Assert.assertEquals("용하가", KoreanUtils.이가_가("용하"));
        Assert.assertEquals("용하를", KoreanUtils.을를("용하"));
        Assert.assertEquals("용하와", KoreanUtils.과와("용하"));
        Assert.assertEquals("용하여", KoreanUtils.이여("용하"));
    }

    @Test
    public void 종성_있는_한글() {
        Assert.assertEquals("소율은", KoreanUtils.은는("소율"));
        Assert.assertEquals("소율이", KoreanUtils.이가("소율"));
        Assert.assertEquals("소율이가", KoreanUtils.이가_가("소율"));
        Assert.assertEquals("소율을", KoreanUtils.을를("소율"));
        Assert.assertEquals("소율과", KoreanUtils.과와("소율"));
        Assert.assertEquals("소율이여", KoreanUtils.이여("소율"));
    }

    @Test
    public void 종성_없는_영문() {
        Assert.assertEquals("Yongha는", KoreanUtils.은는("Yongha"));
        Assert.assertEquals("Yongha가", KoreanUtils.이가("Yongha"));
        Assert.assertEquals("Yongha가", KoreanUtils.이가_가("Yongha"));
        Assert.assertEquals("Yongha를", KoreanUtils.을를("Yongha"));
        Assert.assertEquals("Yongha와", KoreanUtils.과와("Yongha"));
        Assert.assertEquals("Yongha여", KoreanUtils.이여("Yongha"));
    }

    @Test
    public void 종성_없는_숫자() {
        Assert.assertEquals("12는", KoreanUtils.은는("12"));
        Assert.assertEquals("12가", KoreanUtils.이가("12"));
        Assert.assertEquals("12를", KoreanUtils.을를("12"));
        Assert.assertEquals("12와", KoreanUtils.과와("12"));
    }

    @Test
    public void 종성_있는_숫자() {
        Assert.assertEquals("123은", KoreanUtils.은는("123"));
        Assert.assertEquals("123이", KoreanUtils.이가("123"));
        Assert.assertEquals("123을", KoreanUtils.을를("123"));
        Assert.assertEquals("123과", KoreanUtils.과와("123"));
    }

    @Test
    public void 빈_문자열() {
        Assert.assertEquals("''은", KoreanUtils.은는(""));
        Assert.assertEquals("''이", KoreanUtils.이가(""));
        Assert.assertEquals("''을", KoreanUtils.을를(""));
        Assert.assertEquals("''과", KoreanUtils.과와(""));
        Assert.assertEquals("''이여", KoreanUtils.이여(""));
    }

    @Test
    public void 알_수_없는_문자열() {
        Assert.assertEquals("Soyul은(는)", KoreanUtils.은는("Soyul"));
        Assert.assertEquals("Soyul이(가)", KoreanUtils.이가("Soyul"));
        Assert.assertEquals("Soyul이가(가)", KoreanUtils.이가_가("Soyul"));
        Assert.assertEquals("Soyul을(를)", KoreanUtils.을를("Soyul"));
        Assert.assertEquals("Soyul과(와)", KoreanUtils.과와("Soyul"));
        Assert.assertEquals("Soyul이여(여)", KoreanUtils.이여("Soyul"));
    }

    @Test
    public void null_문자열() {
        Assert.assertEquals("null은", KoreanUtils.은는(null));
        Assert.assertEquals("null이", KoreanUtils.이가(null));
        Assert.assertEquals("null을", KoreanUtils.을를(null));
        Assert.assertEquals("null과", KoreanUtils.과와(null));
    }

}
