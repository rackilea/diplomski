private static int checkArgs2(String[] args) {
    if (args == null || args.length == 0) {
        System.out.println("Error: No Args");
        return -1;
    }
    if ( ! checkInt(args[0])) {
        // If it's a String
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