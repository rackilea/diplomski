public MyTokenStream {
    public Token nextToken() {
        // ...
    }
}

public TokenStream plumb() {
    return new MyTokenStream();
}