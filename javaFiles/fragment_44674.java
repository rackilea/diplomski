public static void main(String[] args) {
    Object[][] table = new Object[13][];
    Scanner sc = new Scanner(System.in);
    int i = 0;
    while (sc.hasNextLine()) {
        String sc1 = sc.nextLine();
        table[i] = sc1.split(" ");
        i++;
    }
    sc.close();
    System.out.println(Arrays.deepToString(table));
}