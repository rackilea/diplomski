public static void main(String[] args) {
    /* Move Scanner outside of do-while */
    Scanner keyboard = new Scanner(System.in);
    String s = null;
    String sz = null;
    do {
        System.out.println("Enter Integer Value: ");
        /* Integer Parsing */
        String str = keyboard.nextLine();
        System.out.println("Entered Integer: " + str);
        int myint = Integer.parseInt(str);

        if(myint < 0){
            System.out.println("Value Less Than Zero!");
        }
        else
        {    
            s = getVal(myint);
            System.out.println("Value :: " + s);
        }
        System.out.println("Do you want to continue ? (yes/no)");
        sz = keyboard.nextLine();
        System.out.println("Entered Value: " + sz);
    } while(sz.equalsIgnoreCase("yes"));
}

public static String getVal(int num){
    return num == 0 ? "ZERO" : "One+";   
}