String s = "1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9";
System.out.println(s);
Scanner sc = new Scanner(s);
while (sc.hasNextInt()) {
    System.out.print(sc.nextInt());
    if (sc.hasNextInt()) {
        System.out.print(sc.nextInt());
    }
    if (sc.hasNextInt()) {
        System.out.print(sc.nextInt());
    }
    if (sc.hasNextInt()) {
        System.out.print(sc.nextInt());
    }
    System.out.println();
}