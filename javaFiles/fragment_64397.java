if (playersguess < 99 && playersguess > 10) {
    computersguess = (int) (Math.random() * 10);
    int computersguess2 = (int) (Math.random() * 10);
    System.out.println("My guess is " + computersguess + computersguess2);
} else {
    System.out.println("Your number is not between 10 and 99, please reset game");
}