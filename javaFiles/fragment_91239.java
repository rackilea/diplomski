public static void main(String[] args) {
    String name;
    int age;
    boolean trueOrFalse;
    boolean trueOrFalse2;

    String builtInPassword = "anybody";

    Scanner keyBoardInput = new Scanner(System.in);

        System.out.print("Please enter your First name: ");
        name = keyBoardInput.next();
        System.out.print("Please enter your age: ");
        age = keyBoardInput.nextInt();
        trueOrFalse = false;
        trueOrFalse2 = true;
        System.out.print("Please enter your Password: ");
    if (keyBoardInput.next().equals(builtInPassword)) {
        System.out.println(trueOrFalse2);
    } else {
        System.out.println(trueOrFalse);
    } 
}