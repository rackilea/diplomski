package com.sandbox;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SandboxTest {

    @Test
    public void testMocking() {
        assertEquals("foo", stringBits("f1o2o3"));
    }

    public String stringBits(String str) {
        StringBuffer tmp = new StringBuffer();
        for (int i = 0; i < str.length(); i += 2) {
            tmp.append(str.charAt(i));
        }
        String ret = new String(tmp);
        return ret;
    }
}