boolean isName = false;
String name = "";
Scanner input = new Scanner(System.in);

while (!isName) {
    System.out.print("Please input your 'First Middle Last' name: ");
    name = input.nextLine();
    isName = (name.trim().split("\\s+").length == 3);
    if (!isName) {
        System.out.print("\nEnter your name as 'First Middle Last': ");
    }
}