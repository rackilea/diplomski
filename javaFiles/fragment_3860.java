calendar.set(GregorianCalendar.YEAR, Integer.parseInt(dateArr[2]));
calendar.set(GregorianCalendar.MONTH, Integer.parseInt(dateArr[0])-1);
calendar.set(GregorianCalendar.DATE, Integer.parseInt(dateArr[1]));

System.out.println(arrayOfDays[calendar.get(Calendar.DAY_OF_WEEK) - 1] + ", " +  
arrayOfMonths[calendar.get(Calendar.MONTH)] + " " + calendar.get(Calendar.DATE) + ", " + calendar.get(Calendar.YEAR));