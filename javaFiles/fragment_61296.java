Scanner input = new Scanner(System.in);
int l; // it should be int if read int
l = input.nextInt();
if (l <= 30) {
    System.out.println("40 Sinas");
}
if (l > 30 && l < 50) {
    System.out.println("55 Sinas");
}
if (l > 50 && l < 100) {
    System.out.println("70 Sinas");
}
if (l >= 100) {
    System.out.println(((((l - 100) / 50) + 1) * 25) + 70);
}