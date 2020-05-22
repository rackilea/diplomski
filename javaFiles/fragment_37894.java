Scanner sc = new Scanner(System.in); //your scanner instance
System.out.print("Enter a number.");
while (!sc.hasNextInt()) {
        System.out.println("Enter a whole number");
        sc.next();
}
int x = sc.nextInt();