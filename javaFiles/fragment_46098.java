if (correctc == 3 && correctp == 3){
    System.out.println("\nUser wins! Colour was " + colchoice);
    System.out.println("Press 1 to play again with a new combo.");
    pagain = myInput.readLine(); // game starts with new combo or ends
}

// User tries guessing again
else{
    System.out.println("\nEnter 1 to guess again.");
    loop = myInput.readLine();
}

}while("1".equals(loop)); // user continues guessing the same combo
}while("1".equals(pagain)); // new game with new combo