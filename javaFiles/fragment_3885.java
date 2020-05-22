String select;
do {
    select = input.next();
    if(select.equalsIgnoreCase("O")) {
        System.out.println(name + " is Odd! The computer will be Even!");
    } else if(select.equalsIgnoreCase("E")) {
        System.out.println(name + " is Even! The computer will be Odd!");
    }
} while(!select.equalsIgnoreCase("e") && !select.equalsIgnoreCase("o"));