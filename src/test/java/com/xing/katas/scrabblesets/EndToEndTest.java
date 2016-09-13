package com.xing.katas.scrabblesets;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by marcal.perapoch on 12/09/16.
 */
public class EndToEndTest {

    private ScrabbleKata scrabbleKata;
    private PrettyPrinter prettyPrinter;

    @Before
    public void init() {
        scrabbleKata = new ScrabbleKata();
        prettyPrinter = new ScrabbleKataPrinter();
    }

    @Test
    public void fullTest() {
        final String result = prettyPrinter.print(scrabbleKata.play("AEERTYOXMCNB_S"));
        assertThat(result, is("{10=[E], 9=[I], 8=[A], 7=[O], 5=[N, R, T], 4=[D, L, U], 3=[G, S], 2=[F, H, P, V, W], 1=[B, C, J, K, M, Q, Y, Z, _], 0=[X]}"));
    }
}
