package com.xing.katas.scrabblesets;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by marcal.perapoch on 12/09/16.
 */
public class ScrabbleKataTest {

    private ScrabbleKata scrabbleKata;

    @Before
    public void before() {
        this.scrabbleKata = new ScrabbleKata();
    }

    @Test(expected = IllegalArgumentException.class)
    public void play_shouldThrowExceptionOnInvalidInput() {
        scrabbleKata.play("ZZ");
    }

    @Test(expected = IllegalArgumentException.class)
    public void play_shouldThrowExceptionWhenInvalidCharacter() {
        scrabbleKata.play("--42$%");
    }

    @Test
    public void play_shouldDecreaseTheCounterOfTheExistingLettersInTheMap() {
        Map<String, Integer> result =  scrabbleKata.play("AEERTYOXMCNB_S");
        assertThat("A has decreased 1", result.get("A"), is(8));
        assertThat("E has decreased 2", result.get("E"), is(10));
        assertThat("R has decreased 1", result.get("R"), is(5));
        assertThat("_ has decreased 1", result.get("_"), is(1));
    }

}
