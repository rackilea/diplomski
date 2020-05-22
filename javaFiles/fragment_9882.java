public int firstDayOfYear(int day, int month, int year) {
        int day = day + (2*month) + ((3*(month+1))/5) + year + (year/4) - (year/100) + (year/ 400) +2;
        return day % 7;
    }

 System.out.println("First day of the year: " + newCal.firstDayOfYear(1, 1, inYear));