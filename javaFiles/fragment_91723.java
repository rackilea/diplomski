String s;
System.out.print("Enter a text: ");
try (Scanner sc = new Scanner(System.in)) {
    s = sc.nextLine();
}

try (Scanner in = new Scanner(System.in)) {
    System.out.print("Enter another text: ");
    s = in.nextLine();
}