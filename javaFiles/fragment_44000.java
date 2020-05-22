public static int minimalValue(Stack<Integer> s) {
    if (s.isEmpty())
        return Integer.MAX_VALUE;
    int last = s.pop();
    int min = Math.min(last, minimalValue(s));
    s.push(last);
    return min;
}