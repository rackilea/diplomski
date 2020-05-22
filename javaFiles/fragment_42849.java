String line = s.nextLine();
if (line.matches("[1-5]")) {
    topChoice = Integer.parseInt(line);
} else {
    System.out.println("You need to enter an integer between 1-5.");
    topChoice = 0;
}