public static void main(String[] args) {
    char aa = '\u2648';
    char ab = '\u2649';
    char ac = '\u264A';
    char ad = '\u264B';
    char ae = '\u264C';
    char af = '\u264D';
    char ag = '\u264E';
    char ah = '\u264F';
    char ai = '\u2650';
    char aj = '\u2651';
    char ak = '\u2652';
    char al = '\u2653';

    PrintStream out = null;
    try {
        out = new PrintStream(System.out, true, "UTF-8");
    } catch (UnsupportedEncodingException e) {
        e.printStackTrace();
    }

    out.println("" + aa + ab + ac + ad + ae + af + ag + ah + ai + aj + ak + al);
}