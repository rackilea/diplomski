while (true) {
    System.out.print("Please type in a sentence: ");
    String input = in.nextLine(); //get the input

    if (input.equals("quit")) {
        System.out.println("Exiting program... ");
        break;
    }

    String[] inputLineWords = input.split(" "); //split the string into an array of words
    for (String word : inputLineWords) {        //for each word
        System.out.print(scramble(word) + " "); //print the scramble followed by a space
    }
    System.out.println(); //after printing the whole line, go to a new line
}