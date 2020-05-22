private static class Postfix {
    private void convert(String postfix) {
        Stack<String> s = new Stack<>();

        for (int i = 0; i < postfix.length(); i++) {
            char o = postfix.charAt(i);
            if (isOperator(o)) {
                if (o == '~') {
                    String a = s.pop();
                    if ( a.size() > 1 ) { a = "(" + a + ")"; }
                    s.push("" + o + a);
                }
                else {
                    String b = s.pop();
                    String a = s.pop();
                    if ( o == '*' || o == '/' ) {
                        if ( b.size() > 1 ) { b = "(" + b + ")"; }
                        if ( a.size() > 1 ) { a = "(" + a + ")"; }
                    }
                    s.push("" + a + o + b);
                }
            } else {
                s.push("" + o);
            }
        }
        System.out.println("<INF>" + s.pop().toString());
    }
}