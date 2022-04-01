package com.somecompany.util;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static com.somecompany.util.LinkedHashMapUtil.sortLHM;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LinkedHashMapUtilTest {
    @Test
    public void testSortLHM() {
        final Map<String, Integer> map = new HashMap<>();
        map.put("2", 2);
        map.put("1", 1);

        final LinkedHashMap<String, Integer> sortedMap
                = sortLHM(map, (entry1, entry2) -> (entry1.getValue() - entry2.getValue()));

        assertEquals(sortedMap.toString(), "{1=1, 2=2}");
    }
}
