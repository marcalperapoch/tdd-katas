package com.xing.katas.scrabblesets;

import java.math.MathContext;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by marcal.perapoch on 12/09/16.
 */
public class ScrabbleKata {

    private static final Pattern VALIDATOR_PATTERN = Pattern.compile("[A-Z_]+");

    private static final Map<String, Integer> INITIAL_MAP = new HashMap<>();
    static {
        INITIAL_MAP.put("A", 9);
        INITIAL_MAP.put("B", 2);
        INITIAL_MAP.put("C", 2);
        INITIAL_MAP.put("D", 4);
        INITIAL_MAP.put("E", 12);
        INITIAL_MAP.put("F", 2);
        INITIAL_MAP.put("G", 3);
        INITIAL_MAP.put("H", 2);
        INITIAL_MAP.put("I", 9);
        INITIAL_MAP.put("J", 1);
        INITIAL_MAP.put("K", 1);
        INITIAL_MAP.put("L", 4);
        INITIAL_MAP.put("M", 2);
        INITIAL_MAP.put("N", 6);
        INITIAL_MAP.put("O", 8);
        INITIAL_MAP.put("P", 2);
        INITIAL_MAP.put("Q", 1);
        INITIAL_MAP.put("R", 6);
        INITIAL_MAP.put("S", 4);
        INITIAL_MAP.put("T", 6);
        INITIAL_MAP.put("U", 4);
        INITIAL_MAP.put("V", 2);
        INITIAL_MAP.put("W", 2);
        INITIAL_MAP.put("X", 1);
        INITIAL_MAP.put("Y", 2);
        INITIAL_MAP.put("Z", 1);
        INITIAL_MAP.put("_", 2);
    }

    public ScrabbleKata() {
    }

    public Map<String, Integer> play(final String input) {
        final Map<String, Integer> workingMap = new HashMap<>(INITIAL_MAP);
        checkValidCharacters(input);
        input.chars().forEach(c -> {
            workingMap.computeIfPresent(String.valueOf((char) c), (s,x) -> {
                int nexValue = x - 1;
                if (nexValue < 0) {
                    throw new IllegalArgumentException("Invalid input. More Q's have been taken from the bag than possible.");
                }
                return nexValue;
            });
        });
        return workingMap;
    }

    private void checkValidCharacters(String input) {
        final Matcher matcher = VALIDATOR_PATTERN.matcher(input);
        if (!matcher.find()) {
            throw new IllegalArgumentException("Invalid input :(");
        }
    }

    public static void main(String[] args) {
        final ScrabbleKata scrabbleKata = new ScrabbleKata();
        final PrettyPrinter prettyPrinter = new ScrabbleKataPrinter();
        try(Scanner scanner = new Scanner(System.in)) {
            Map<String, Integer> map = scrabbleKata.play(scanner.next());
            System.out.println(prettyPrinter.print(map));
        }
    }

}
