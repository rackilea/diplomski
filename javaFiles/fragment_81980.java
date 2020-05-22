public static void main(String[] args) throws IOException {
    String s1 = "  2013-2014  XXX 29 ";
    System.out.println(s1.replaceAll("^\\s+([\\d-]+)\\s+(\\w+).*", "$1 $2"));

    String s2 = "  2011-2012  XXXX 44 ";
    System.out.println(s2.replaceAll("^\\s+([\\d-]+)\\s+(\\w+).*", "$1 $2"));
}