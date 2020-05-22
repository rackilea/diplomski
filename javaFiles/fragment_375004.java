Scanner in = new Scanner(System.in);
    boolean exit = false;
    int choice = 0;

    while (!exit)
    {
        System.out.println("1 Find an item.\n2 Display all items.\n3 Update item.\n4 Save item to disk.\n5 Quit.");
        while(in.hasNext()){
        //next token available
        if(in.hasNextInt()){
        /next token is an int value
        choice = in.nextInt();
        }
}
}