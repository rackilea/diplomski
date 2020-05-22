boolean hasSeenM = false;

    for (int i = 0; i < list.size(); i++) {
        if ( !hasSeenM && list.get(i).equals("M")) {
            hasSeenM = true;
        }
        // this is to indicate that i need to continue further operations
        // inside for loop
        System.out.println("Hi");

    }

    if (hasSeenM)
        System.out.println("This is M List");
    else
        System.out.println("This is F List");