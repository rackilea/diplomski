public static void main(final String[] args) {
    final Pattern p = Pattern.compile("^([a-zA-Z]+\\*?|\\*)\\w*$");

    System.out.println(p.matcher("TE").matches());
    System.out.println(p.matcher("*TE").matches());
    System.out.println(p.matcher("TE*").matches());
    System.out.println(p.matcher("T*E").matches());
    System.out.println(p.matcher("*9TE").matches());
    System.out.println(p.matcher("*TE*").matches());
    System.out.println(p.matcher("9E").matches());
}