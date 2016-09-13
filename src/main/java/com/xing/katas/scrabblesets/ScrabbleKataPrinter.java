package com.xing.katas.scrabblesets;

import java.util.*;

/**
 * Created by marcal.perapoch on 12/09/16.
 */
public class ScrabbleKataPrinter implements PrettyPrinter {
    @Override
    public String print(Map<String, Integer> map) {
        final Map<Integer, TreeSet<String>> matrix = new TreeMap<>((Comparator) (o1, o2) -> (Integer) o2 - (Integer) o1);
        map.entrySet().stream().forEach(entry -> {
            final String letter = entry.getKey();
            final Integer frequency = entry.getValue();
            if (!matrix.containsKey(frequency)) {
                matrix.put(frequency, new TreeSet<>());
            }
            final TreeSet<String> letters = matrix.get(frequency);
            letters.add(letter);
        });
        return matrix.toString();
    }
}
