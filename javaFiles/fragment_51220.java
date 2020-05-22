public static void main(String[] args) {


    int yil, bolum = 0, kalan;
    ArrayList liste = new ArrayList();
    System.out.println("Yıl Girin: "); // enter the 1453
    yil = 1453;

    String s="";
    do { // process makes 1453 separate then write in the arraylist like that [3, 5, 4,1]

        kalan = yil % 10;
        liste.add(kalan);
        s= s + kalan;  // <------- THE SOLUTION AT HERE  -------

        bolum = yil / 10;
        yil = bolum;

    } while (bolum != 0);

    System.out.println("Sayının Tersi: " + s ); //reverse of the 1453

}