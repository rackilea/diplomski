public static void OptionUn (String[][] TableauLectureFichier) {

    Scanner rDates = new Scanner(System.in);

    System.out.println("ENTER YOUR INTERVAL HERE IN THE FOLLOWING ORDER DAY1 MONTH1 DAY2 MONTH2");

    String Intervale = rDates.nextLine();

    String[] TabChaine = Intervale.split(" ");
    int[] tIntervale = new int[4];

    for (int i = 0; i <TabChaine.length; i++) {            
        tIntervale[i] = Integer.parseInt(TabChaine[i]);
    }

    int j1 = tIntervale[0],
        j2 = tIntervale[2],
        m1 = tIntervale[1],
        m2 = tIntervale[3];

    // Loop through all the months specified, taking care to convert from base 1 
    // to base 0
    for (int month = m1 - 1; month < m2; month++) {
        // Assume that we will start at the first day of a month
        int day = 0;

        // However, if the current month is the first, start from the day specified as j1 
        // instead, and convert to base 0 so that we can use it to index into the array
        if (month == m1) {
            day = j1 - 1;
        }

        // Assume that we will run till the end of this month, or in this case to the end
        // of the array for the current month
        int endDay = TableauLectureFichier[month].length;

        // If the current month is the last month, only run to specified end day
        if (month == m2) {
            endDay = j2;
        }

        // Now run from the start day to the end day in the current month, paying 
        // attention to that endDay is still base 1
        for (; day < endDay; day++) {
            System.out.println(String.format("Month: %d, day: %d, value %s",
                month, 
                day, 
                TableauLectureFichier[month][day]));
        }

        // At this point we will step into the next month
    }
}