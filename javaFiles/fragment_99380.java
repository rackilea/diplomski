int size = 0;
    for (String s : input) {
        size += s.length();
    }

    char[] output = new char[size];
    int start = 0;
    for (String s : input) {
        System.arraycopy(s.toCharArray(), 0, output, start, s.length());
        start+=s.length();
    }