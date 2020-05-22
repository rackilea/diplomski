for(;;) {
    System.out.print("Type a word: ");
    enteredWord = reader.nextLine();
     if(words.contains(enteredWord)) {
        break; //ends loop
     }
     words.add(enteredWord);
}