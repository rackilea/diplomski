String days[] = { "", "Monday", "Tuesday", "Wednesday", "Thursday",
            "Friday", "Saturday", "Sunday" };
    boolean finish = false; // use a readable variable name

    while (!finish) {
        System.out.println("Please enter a day: ");
        day = in.nextLine();
        for (int i = 1; i < days.length; i++) {
            if (day.equalsIgnoreCase(days[i])) { // match upper and lower case
                System.out.println("the index of day in the array is " + (i + 1));
                finish = true;
                break; // stop the loop if found the day in array
            }
        }
        if (!finish)
            System.out.println("Can't find " + day
                    + " in the array, please try again!");
    }