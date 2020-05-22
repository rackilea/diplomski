public static void main (String[] args) throws java.lang.Exception
    {
        String[] expr = new String[]{"67", "+", "45", "-", "12", "*", "5", "/", "78"};
        int current = 0;
        StringBuilder postfix = new StringBuilder();

        // handle first three
        postfix.append(expr[current]).append(" ");
        postfix.append(expr[current+2]).append(" ");
        postfix.append(expr[current+1]).append(" ");
        current += 3;

        // handle rest
        while( current <= expr.length-2 ){
            postfix.append(expr[current+1]).append(" ");
            postfix.append(expr[current]).append(" ");
            current += 2;
        }

        System.out.println(postfix.toString());
    }