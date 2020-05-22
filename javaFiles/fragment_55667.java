Scanner java = new Scanner(System.in);
int from, to;
System.out.println("Enter a number: ");
to = java.nextInt();
for (from = 1; from < to; from+=2) {
    System.out.println(from);
}