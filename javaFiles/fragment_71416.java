public static void main(String arg[]) throws IOException {
    int k, i;
    char a;
    k = 0;
    Scanner in = new Scanner(System.in);

    for (i = 0; i <= 3; i++) {
        k++;
        a = in.next().charAt(0);
        System.out.println(k);
    }
}