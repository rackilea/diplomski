String ordinal(int day, int month, int year) {
        String[] day1 = new String[]{"th", "st", "nd", "rd", "th", "th", "th", "th", "th", "th"};

        String monthString = ""; //declare here

        switch (day % 100) {
            case 11:
            case 12:
            case 13:
                Log.w(TAG, day + "th");

                switch (month) {
                    case 1:  monthString = "January";
                        break;
                    case 2:  monthString = "February";
                        break;
                    case 3:  monthString = "March";
                        break;
                    case 4:  monthString = "April";
                        break;
                    case 5:  monthString = "May";
                        break;
                    case 6:  monthString = "June";
                        break;
                    case 7:  monthString = "July";
                        break;
                    case 8:  monthString = "August";
                        break;
                    case 9:  monthString = "September";
                        break;
                    case 10: monthString = "October";
                        break;
                    case 11: monthString = "November";
                        break;
                    case 12: monthString = "December";
                        break;
                }
                break; //you're missing this break after the case
        }
        return day + monthString;
    }