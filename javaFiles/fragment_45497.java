static int readIntegers(int count) 
    throws IOException {
    BufferedReader reader = new BufferedReader(
           new InputStreamReader(input) );
    StringTokenizer tokenizer = new StringTokenizer("");
    int last = 0;
    while (count-- > 0) {
        if (! tokenizer.hasMoreTokens() ) {
            tokenizer = new StringTokenizer(reader.readLine());
        }
        last = Integer.parseInt(tokenizer.nextToken());
    }
    return last;
}