Scanner scanner = new Scanner(System.in);
int x = scanner.nextInt();
int y = scanner.nextInt();
String function = scanner.next();
if (function == "age") {
    int sum = x + y;
    System.out.println(sum);
}