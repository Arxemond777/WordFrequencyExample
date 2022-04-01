package com.somecompany.util;

import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static com.somecompany.util.WordFrequencyUtil.calcWordFreq;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * @author <a href="mailto:1arxemond1@gmail.com">Iurii Glushenkov</a>
 */
public class WordFrequencyUtilTest {
    @Test
    public void testNormalWordFreq() {
        String sentence = "   asd, 9 df92 FDDF   gfgd gfgd    ";

        Map<String, Integer> map = new LinkedHashMap<>();
        map.put("gfgd", 2);
        map.put("asd", 1);
        map.put("9", 1);
        map.put("df92", 1);
        map.put("FDDF", 1);
        assertEquals(calcWordFreq(sentence).toString(), map.toString());

        Map<String, Integer> map2 = new LinkedHashMap<>();
        map2.put("asd", 1);
        map2.put("gfgd", 2);
        map2.put("9", 1);
        map2.put("df92", 1);
        map2.put("FDDF", 1);
        assertNotEquals(calcWordFreq(sentence).toString(), map2.toString());
    }

    @Test
    public void testForeignerLanguagesWordFreq() {
        String sentence = "asd,9 df92 FDDF   нет    是 I'm  Ä, Ö, Üß Üß";
        Map<String, Integer> map = new LinkedHashMap<>();
        map.put("Üß", 2);
        map.put("asd9", 1);
        map.put("df92", 1);
        map.put("FDDF", 1);
        map.put("нет", 1);
        map.put("是", 1);
        map.put("I'm", 1);
        map.put("Ä", 1);
        map.put("Ö", 1);
        assertEquals(calcWordFreq(sentence).toString(), map.toString());

    }
}
