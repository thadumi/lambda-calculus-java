package com.thadumi.talks.lambdacalculus;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static com.thadumi.talks.lambdacalculus.LC.*;

class LCTest {

    @Test
    void idiotBirdSample() {
        assertEquals(I, Idiot);

        assertEquals(I, I.apply(I));
        assertEquals(M.apply(I), I.apply(I));
    }

    @Test
    void kestrelSample() {
        assertEquals(K, Kestrel);

        assertEquals(M, K.apply(M).apply(I));
    }

    @Test
    void kiteSample() {
        assertEquals(KI, Kite);

        assertEquals(I, KI.apply(M).apply(I));
    }

    @Test
    void testBooleanAndOperation() {
        assertEquals(T, AND.apply(T).apply(T));
        assertEquals(F, AND.apply(T).apply(F));
        assertEquals(F, AND.apply(F).apply(T));
        assertEquals(F, AND.apply(F).apply(F));
    }

    @Test
    void testBooleanOrOperation() {
        assertEquals(T, OR.apply(T).apply(T));
        assertEquals(T, OR.apply(T).apply(F));
        assertEquals(T, OR.apply(F).apply(T));
        assertEquals(F, OR.apply(F).apply(F));
    }

    @Test
    void testPair() {
        λ pair = PAIR.apply(T).apply(F);

        assertEquals(T, FST.apply(pair));
        assertEquals(F, SND.apply(pair));
    }


    @Test
    void tesNumbers() {
        assertEquals(T, isZero.apply(ZERO));
        assertEquals(F, isZero.apply(SUCCESSOR.apply(ZERO)));
    }
}
