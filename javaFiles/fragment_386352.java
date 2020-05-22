public static void printNumbersB() {
Scanner input = new Scanner(System.in);
System.out.print("Please put in: ");
int x = input.nextInt();
input.close();
//Should use String builder
String tab = "";
int lineNumber;
int num = 1;
breakfor:
for (int i = 1; i <= x; i++) {
    System.out.println();
    lineNumber = i;
    tab = tab + " ";
    for (int j = lineNumber; j > 0; j--) {
        System.out.print(tab + num);
        num = num + 1;
        if(num > x)
            break breakfor;
    }

}