public void update() {
    final String guessString = keyboard.next();

    System.out.println("\033[1A\033[" + guessString.length() + 'C'
        + "\t{next col}");
}