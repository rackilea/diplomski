static boolean IsAMatch(String actual, String expected) {
        char faultyKey = '\0';
        int i = 0, j = 0;
        for (; i < expected.length(); ++i) {
            if (j >= actual.length() || actual.charAt(j) != expected.charAt(i)) {
                if ('\0' != faultyKey) {
                    if (faultyKey != expected.charAt(i)) {
                        return false;
                    }
                } else {
                    faultyKey = expected.charAt(i);
                }
            } else {
                ++j;
            }
        }
        System.out.println("FaultyKey= " + faultyKey);
        return (i == expected.length() && j == actual.length()) ? true : false;
    }