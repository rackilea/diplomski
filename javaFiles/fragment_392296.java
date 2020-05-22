Scanner in = new Scanner(System.in);
int numberOfItem = 0;
String str;

while(true) {
    //Get input String
    System.out.print("Enter a string(enter QUIT to quit): ");
    str = in.nextLine();

    if (str.equals("QUIT")) break;
    numberOfItem++;

    System.out.println();
    System.out.print("Input String is: " + str);
    System.out.println(", Number of items: " + numberOfItem);
}