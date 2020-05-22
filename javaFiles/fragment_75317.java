public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int a, zufallszahl;
    zufallszahl = (int) (Math.random() * 100 + 1);
    System.out.print("Enter a number: ");
    a = input.nextInt();
    while (a != zufallszahl) {
        if (a<zufallszahl)System.out.println("zu groß");
        else System.out.println("zu klein boy");
        System.out.println("Try again: ");
        a = input.nextInt();
    }

    System.out.println("        B        I       N        G         O        ");
}