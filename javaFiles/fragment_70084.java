else if (user.equals("R") || user.equals("r")) {
    if (comp.equals("S"))
        System.out.println("Rock beats scissor - you win!");
    else if (comp.equals("P"))
        System.out.println("Paper beats rock - you lose");
}
else if (user.equals("P")||user.equals("p")) {
    if (comp.equals("S"))
        System.out.println("Scissors beats paper- you lose");
    else if (comp.equals("R")|| comp.equals("r"))
        System.out.println("Paper beats rock - you win");
}
else if (user.equals("S")||user.equals("s")) {
    if (comp.equals("P"))
        System.out.println("Scissors beats paper - you win!");
    else if (comp.equals("R"))
        System.out.println("Rock beats scissors - you lose!");
}