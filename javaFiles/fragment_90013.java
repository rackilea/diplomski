package com.ibm.icu.text;

public class Normalizer {

    public static final int getClass(final char ch) {
        final int value = DecompData.canonClass.elementAt(ch);
        return value >= 0 ? value : value + 256;
    }

}