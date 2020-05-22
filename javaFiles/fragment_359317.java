while(true) {
    System.out.println("What would you like to add to your plan (options are a,b,c, or d. Enter -1 when you are finished):  ");
    String yourChoice = scanner.nextLine();
    if(yourChoice.equals(SENTINEL))
        return;
}