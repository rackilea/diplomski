public static void saisir(String sclavier[]) {
    int p = 0;
    Scanner reader = new Scanner(System.in);
    while (p < 5) {
        System.out.print("saisir une chaine de caracter");
        sclavier[p] = reader.nextLine();
        p++;
    }
}