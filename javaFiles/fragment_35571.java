public static void getCount(ArrayList<Integer> array) {

    Hashtable<Integer, Integer> table = new Hashtable<>();

    for (int i = 0; i < array.size(); i++) {
        if (table.containsKey(array.get(i))) {
            count = table.get(array.get(i));
            table.put(array.get(i), ++count);
        } else {
            table.put(array.get(i), 1);
        }
    }
    set = table.keySet();
    count = 0;
    for (Integer n : set) {
        count = table.get(n);
        System.out.println(n + ": Frequency - " + count);
    }
    System.out.println();
    count = 0;
    System.out.println("PERCENTAGE REPORT");
    for(Integer n : set) {
        tally = 0; //<---Tally was being calculated twice. Had to reset.
        countNonSpaces(array); //get the tally once more after resetting
        count = table.get(n);
        double percentage = (count*100.0)/tally; //percentage is essentially "count" with an additional calculation so no new method needed
        percentage = percentage * 100;
        percentage = Math.round(percentage);
        percentage = percentage/100;
        System.out.println(n + ": Percentage - " + percentage + "%");
    }
    System.out.println();
    System.out.println("MOST SIGNIFICANT PERCENTAGES");
    count = 0;
    for(Integer n : set) {
        tally = 0;
        countNonSpaces(array);
        count = table.get(n);
        percentage = (count*100.0)/tally;
        percentage = percentage * 100;
        percentage = Math.round(percentage);
        percentage = percentage/100;

        // Picked a decent number (50), copied the code
        // from the frequency calculation, and added
        // a continue statement to only print the most frequent #'s.

            if(count < 50) { 
            continue;
        }
        System.out.println(n + ": Percentage - " + percentage + "%");
    }
}
public static int countNonSpaces(ArrayList<Integer> array) {

    for (int i = 0; i < array.size(); i++) {
        if (array.get(i) != ' ') {
            tally++;
        }
    }
    return tally;
}
}