public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int a, zufallszahl=(int) (Math.random() * 100 + 1);
    System.out.print("Enter a number: ");
    while ((a = input.nextInt()) != zufallszahl) 
        System.out.println(((a<zufallszahl)?"zu groß":"zu klein boy")+"\nTry again: ");
    System.out.println("        B        I       N        G         O        ");
}