public static void stringBuilderTest(int iterations) {
    final StringBuilder sb = new StringBuilder();
    for (int i = iterations; i-- > 0;) {
        sb.append("a");
    }
}

public static void stringBufferTest(int iterations) {
    final StringBuffer sb = new StringBuffer();
    for (int i = iterations; i-- > 0;) {
        sb.append("a");
    }
}

public static void emptyStringConcatTest(int iterations) {
    String s = new String();
    for (int i = iterations; i-- > 0;) {
        s += "";
    }
}

public static void nonEmptyStringConcatTest(int iterations) {
    String s = new String();
    for (int i = iterations; i-- > 0;) {
        s += "a";
    }
}