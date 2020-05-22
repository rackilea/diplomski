String input = "30 129 48 29 110 90";
    StringTokenizer tokenizer = new StringTokenizer(input);
    int count = tokenizer.countTokens();
    int x[] = new int[count];
    int i=0;
    while (tokenizer.hasMoreElements()) {
        x[i++] = Integer.parseInt((String)tokenizer.nextElement());
    }