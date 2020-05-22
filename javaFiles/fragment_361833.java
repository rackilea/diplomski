while ( choice != -1 ) {
    switch (choice) {
        case 1:
            System.out.println("Enter Homework Grades");
            // add grades to a list until -1 is typed
            List<Integer> grades = new ArrayList<Integer>();
            while (choice != -1) {
                System.out.println("Enter a grade, or -1 to stop entering grades: ");
                choice = dylan.nextInt();
                if (choice > -1) {
                    grades.add(choice);
                }
            }
            // now calculate your average and do whatever else
            break;
        // more cases
    }
    choice = dylan.nextInt();
}

System.out.println( "Exiting program." );