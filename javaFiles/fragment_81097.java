// Return days
    public static String weekDay(int i, int[] array)
    {
        int[] displayWeekDay = searchTemp(array, i);
        String weekDay = "";
        for(i = 0; i < displayWeekDay.length; i++){

            //String weekDay = ""; Declare weekDay outside of the loop
            switch(i)
            {
                //Assign a value to weekDay, simply returning won't do it
                case 0: weekDay = "Sunday"; break;
                case 1: weekDay = "Monday"; break;
                case 2: weekDay = "Tuesday"; break;
                case 3: weekDay = "Wednesdays"; break;
                case 4: weekDay = "Thursday"; break;
                case 5: weekDay = "Friday"; break;
                case 6: weekDay = "Saturday"; break;
            }
        }
        return weekDay;
    }