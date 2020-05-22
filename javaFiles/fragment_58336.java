//Ask if user wants to continue and get input
System.out.println("Make more selections? Type Yes or No");
selec = user_input.next();
//If user enters 'Yes' then have them enter new selection and run query again
if(selec.equalsIgnoreCase("Yes")) {
    System.out.println("Enter next selection: ");
    query();
}