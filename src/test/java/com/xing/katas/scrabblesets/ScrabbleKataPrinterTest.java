package com.xing.katas.scrabblesets;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by marcal.perapoch on 12/09/16.
 */
public class ScrabbleKataPrinterTest {

    // SUT
    private ScrabbleKataPrinter scrabbleKataPrinter;

    @Before
    public void init() {
        scrabbleKataPrinter = new ScrabbleKataPrinter();
    }

    @Test
    public void print_shouldReturnTheFrequencyOfTheLetter() {
        final Map<String, Integer> map = new HashMap<>();
        map.put("A", 2);
        final String expected = "{2=[A]}";
        final String result = scrabbleKataPrinter.print(map);
        assertThat(result, is(expected));
    }

}
