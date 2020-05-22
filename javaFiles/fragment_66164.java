...
    StringTokenizer tok = new StringTokenizer(input, delimiters);
    int count = tok.countTokens();
    array = new String[count];
    int i = 0;
    while (tok.hasMoreTokens()) {
        array[i++] = tok.nextToken();
    }
    ...