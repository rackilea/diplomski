class CharStack {
    final StringBuilder sb = new StringBuilder();

    public void push(char ch) {
        sb.append(ch);
    }

    public char pop() {
        int last = sb.length() -1;
        char ch= sb.charAt(last);
        sb.setLength(last);
        return ch;
    }

    public int size() {
        return sb.length();
    }
}