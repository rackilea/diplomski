if (choice.equalsIgnoreCase("l")) {
    String lower = firstName.toLowerCase();
    System.out.println("Your first name in lowercase is: " + lower);
} else if(choice.equalsIgnoreCase("u")){
    String upper = firstName.toUpperCase();
    System.out.println("Your first name in uppercase is: " + upper);
}
else {
    System.out.println("Invalid entry - must be U or L.");
}