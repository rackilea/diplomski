public static void main(String... args) throws ParseException {
    char[][] symbols = new char[][] { { 'M', 'm' }, { 'o', '0' }, { 'i', 'l', '|', 'e' }, { 's', '$' } };
    String s = "1234";
    for (int i = 0; i < symbols[0].length; i++) {
        s = s.replace(s.charAt(0), symbols[0][i]);
        for (int j = 0; j < symbols[1].length; j++) {
            s = s.replace(s.charAt(1), symbols[1][j]);
            for (int k = 0; k < symbols[2].length; k++) {
                s = s.replace(s.charAt(2), symbols[2][k]);
                for (int l = 0; l < symbols[3].length; l++) {
                    s = s.replace(s.charAt(3), symbols[3][l]);
                    System.out.println(s);
                }
            }
        }
    }

}