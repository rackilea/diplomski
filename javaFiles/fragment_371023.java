Scanner sc = new Scanner(System.in);
System.out.print("Enter number 1: ");
while (!sc.hasNextInt()) sc.next();
int num1 = sc.nextInt();
int num2;
System.out.print("Enter number 2: ");
do {
    while (!sc.hasNextInt()) sc.next();
    num2 = sc.nextInt();
} while (num2 < num1);
System.out.println(num1 + " " + num2);