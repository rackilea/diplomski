private static int checkArgs1(String[] args) {
    if (args == null || args.length == 0) {
        System.out.println("Error: No Args");
        return -1;
    }
    try { // If it's a number
        int myNumber = Integer.parseInt(args[0]);
        System.out.println("My number is: " + myNumber);
    } catch (NumberFormatException e) {// If it's a String
        String[] myStr = args;
        System.out.print("My String is ");
        for (int i = 0; i < args.length; i++) {
            myStr[i] = args[i];
            System.out.print(myStr[i]);
        }
        System.out.print("\n");
        return 0;
    }
    return 0;
}