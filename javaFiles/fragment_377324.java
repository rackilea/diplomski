for (int i = 0; i < 5; i++) {
    for (int j = i + 1; j < 5; j++) {
        String testLine = i + "-" + j;
        int itemA = myMap.get(testLine);

        boolean greaterThanAll = true;

        for (int k = j + 1; k < 5; k++) {
            String newLine = j + "-" + k;
            int itemB = myMap.get(newLine);

            if (itemA <= itemB) {
                System.out.println("Comparison failed: Item " + itemA + " is smaller than " + newLine + " (" + itemB + ")");
                greaterThanAll = false;
                break;
            } else {
                System.out.println("Item A : " + itemA + " is bigger than item "
                        + newLine + " (" + itemB + ")"); // Printing out results to check the loop
            }
        }
        if (greaterThanAll) {
            System.out.println(testLine + "=" + itemA + " is greater than all");
            //IF and ONLY all values of item A that is passed through is bigger than item B
            //THEN trigger an event to group item B with A
        }
    }
}