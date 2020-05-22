boolean isOperator(String s) {
   return s.equals("*") || s.equals("-") || s.equals( "/") || s.equals("+");
}

public void tokenize(String expr) {
    StringTokenizer st = new StringTokenizer(expr);
    while ( st.hasMoreElements() ) {
        String val = st.nextElement().toString();
        if ( isOperator( val ) ) {
            //operator.push(val);
            System.out.println("Val");
            System.out.println(val);
        } 
        else {
            //operand.push(op);
            System.out.println("Operand");
            BigInteger op = new BigInteger(val);
            System.out.println(op);
        }
    }
}