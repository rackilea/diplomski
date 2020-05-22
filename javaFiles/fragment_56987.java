while (!(in.equals("r") || in.equals("p") || in.equals("s"))) {
    System.out.print("Enter 'r' for rock, and 'p' for paper,'s' for scissors:");
    in = input.next();
    if (in.equals("r") || in.equals("p") || in.equals("s")) {
        if (in.equals("r"))
            in = "Rock";
        else if (in.equals("p"))
            in = "Paper";
        else
            in = "Scissors";
                break;
    }
}