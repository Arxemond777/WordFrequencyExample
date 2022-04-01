package com.somecompany.util;

import java.util.*;

import static com.somecompany.util.LinkedHashMapUtil.sortLHM;

/**
 * Util class for some operations with sentences and counting of words in them
 *
 * @author <a href="mailto:1arxemond1@gmail.com">Iurii Glushenkov</a>
 */
public class WordFrequencyUtil {

    /**
     * In more extended version you can use Concurrency or try to do it with ForkJoinPoll
     * if you're going to perform really long strings. The drawback of it may be if you do
     * it in a high-load server-side application with multiple clients because you can exceed
     * the number of threads if you won't control it.
     *
     * To control the length of a sentence you can use validation
     *
     * @param sentence - a piece of text
     * @return
     */
    public static Map<String, Integer> calcWordFreq(String sentence) {
        if (sentence == null) return null;
//        else if (sentence.length() > 100_000) throw new BusinessException("This text is too long"); // if you want to control the length

        Map<String, Integer> wordFreq = new LinkedHashMap<>();
//        sentence = sentence.replaceAll("[^\\da-zA-Z\\s]", ""); // won't work for Cyrillic/Chinese/German/Scandinavian languages
//        sentence = sentence.replaceAll("[^\\d\\p{L}+\\s]", ""); // will work for other languages but not for I'm
        sentence = sentence.replaceAll("[^'\\d\\p{L}+\\s]", ""); // will work for other languages and I'm

        for (String word : sentence.split("\\s+")) {
            wordFreq.put(word, wordFreq.getOrDefault(word, 0) + 1);
        }

        wordFreq = sortLHM(wordFreq, (es1, es2) -> es2.getValue().compareTo(es1.getValue()));


        return wordFreq;
    }
}
