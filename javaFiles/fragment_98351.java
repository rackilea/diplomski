public static int searchChar(char ndd, String funcX) {
    int gabi = funcX.indexOf(ndd);
    return gabi;
}
public static void main(String[] args) {
    System.out.println(searchChar('g', "program"));
}