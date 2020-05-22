public static class Message<T> {
    List<Token<T>> tokens = new ArrayList<>();

    public Message<T> append(Token<T> t) {

        Message<T> mx = new Message<T>();
        if(!isComplete()) {
            mx.tokens.addAll(tokens);
        }
        mx.tokens.add(t);
        return mx;
    }

    public boolean isComplete() {
        int n = tokens.size();
        return n>0 && tokens.get(n-1).isMarker();
    }

    public Optional<List<Token<T>>> fullMessage(){
        return isComplete() ? Optional.of(tokens):Optional.empty(); 
    }
}