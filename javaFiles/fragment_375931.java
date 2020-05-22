Scanner userIn = new Scanner(System.in);
int howMany;
String name;
String answer;

System.out.println("enter number");
howMany = userIn.nextInt();

System.out.println("enter name");
userIn.nextLine();
name = userIn.nextLine();

System.out.println("enter answer");
answer = userIn.nextLine();