package com.somecompany.util;

import java.util.*;

/**
 * Util class for some operations with LinkedHashMap
 *
 * @author <a href="mailto:1arxemond1@gmail.com">Iurii Glushenkov</a>
 */
public class LinkedHashMapUtil {
    public static <K, V> LinkedHashMap<K, V> sortLHM(Map<K, V> map, Comparator<? super Map.Entry<K, V>> cmp) {
        if (map == null || cmp == null) return null;
//        else if (!(map instanceof LinkedHashMap)) throw new BusinessException(); // there is a compromise between Map&LHM

        Set<Map.Entry<K,V>> mapSet = map.entrySet();
        List<Map.Entry<K, V>> mapListEntry = new ArrayList<>(mapSet);
        Collections.sort(mapListEntry, cmp);
        mapSet.clear();

        LinkedHashMap<K, V> res = new LinkedHashMap<>();
        for(Map.Entry<K, V> vk : mapListEntry){
            res.put(vk.getKey(), vk.getValue());
        }

        return res;
    }
}
