package com.sandbox;

import org.junit.Test;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;

import static org.junit.Assert.assertEquals;

public class SandboxTest {

    @Test
    public void testMocking() {
        assertEquals("foo", stringBits("f1o2o3"));
    }

    public String stringBits(String str) {
        StringBuilder buf = new StringBuilder();
        StringCharacterIterator iterator = new StringCharacterIterator(str);
        for (char c = iterator.first(); c != CharacterIterator.DONE; c = iterator.next()) {
            buf.append(c);
            iterator.next();
        }
        return buf.toString();
    }
}