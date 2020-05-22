while(!word.equalsIgnoreCase("Exit")){
    System.out.print("Type words or exit to quit: ");
    word = scan.nextLine();
    value += numberCount(word);
}   
System.out.print("The number of words that start with a number is "+value);