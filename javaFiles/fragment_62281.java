Scanner sc = new Scanner(System.in);
System.out.println("Enter Test Score");
String input = sc.next();
if (input.toLowerCase().contains("q")) {
    throw new RuntimeException("The input is not numeric");
}
int tS = Integer.parseInt(input);

// do something