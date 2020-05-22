String input = "r 3 4";
    if (input.matches("^(help|h|quit|q|((r|reveal) \\d \\d))$"))
        //switch case
        System.out.println("match");

    else
        //null string
        System.out.println("no match");