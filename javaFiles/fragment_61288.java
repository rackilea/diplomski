public static void main(String args[]) {
    char c[], s[];
    String str;
    Scanner scn = new Scanner(System.in);

    str = "Have  a nice   day";

    c = str.toCharArray();
    s = new char[c.length];

    int ii = 0;                                 // ADDED
    for (int i = 0; i < c.length; i++) {
        if (!Character.isSpaceChar(c[i])) {
            System.out.print(c[i]);
            s[ii] = c[i];                       // CHANGED                              
            ii++;                               // ADDED
        }
    }
    System.out.println();
    for (int j = 0; j < s.length; j++)
        System.out.print(s[j]);
}