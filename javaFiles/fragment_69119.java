public static void main(String[] args) {

        String s = "(3+4)*5";
        System.out.println("s = " + s);

        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length ; i++) {
            //System.out.println("s = " + s);
            lookup(chars[i]);
        }
    }

    public static int lookup(int i) {

        switch (i) {
        case '(':
            System.out.println("Next Token = " + "'" + (char)i + "'"
                    + " Next lexeme = 25");
            break;
        case ')':
            System.out.println("Next Token = " + "'" + (char)i + "'"
                    + " Next lexeme = 26");
            break;
        case '+':
            System.out.println("Next Token = " + "'" + (char)i + "'"
                    + " Next lexeme = 21");
            break;
        case '-':
            System.out.println("Next Token = " + "'" + (char)i + "'"
                    + " Next lexeme = 22");
            break;
        case '*':
            System.out.println("Next Token = " + "'" + (char)i + "'"
                    + " Next lexeme = 23");
            break;
        case '/':
            System.out.println("Next Token = " + "'" + (char)i + "'"
                    + " Next lexeme = 24");
        default:
            System.out.println("Next Token = " + "'" + (char)i + "'"
                    + " Next lexeme = 20");
        }
        return 0;
    }