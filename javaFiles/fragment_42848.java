try {
    topChoice = Integer.parseInt(s.next("[1-5]"));
} catch (InputMismatchException e) {
    System.out.println("You need to enter an integer between 1-5.");
    s.nextLine(); // <----- here
    topChoice = 0; // <---- and here
}