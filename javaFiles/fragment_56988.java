public static void main(String[] args) {
    String in = "";
    Scanner input = new Scanner(System.in);
    while (!(in.equals("Rock") || in.equals("Paper") || in.equals("Scissors"))) {
        System.out.print("Enter 'r' for rock, and 'p' for paper,'s' for scissors:");
        in = input.next();
        if (in.equals("r") || in.equals("p") || in.equals("s")) {
            if (in.equals("r")) {
                in = "Rock";
            }
            if (in.equals("p")) {
                in = "Paper";
            }
            if (in.equals("s")) {
                in = "Scissors";
            }
            break;
        }
    }
    input.close();
    System.out.print(in);
}