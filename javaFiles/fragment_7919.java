System.out
            .println("Last Name\t\tStartWeight\t\tEnd Weight\t\tWeight Change");
    // PARSE THE ARRAY
    for (int i = 0; i < students.length; i++) {
        System.out.println(students[i].getName() + "\t\t"
                + students[i].getStart() + "\t\t" + students[i].getEnd()
                + "\t\t" + students[i].getChange());
    }