private static String getNextWeek(int weekFromToday) {
        Calendar mCalendar = new GregorianCalendar(); 
        mCalendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        mCalendar.set(Calendar.WEEK_OF_YEAR, 
                mCalendar.get(Calendar.WEEK_OF_YEAR) + weekFromToday);          

        SimpleDateFormat mDF = new SimpleDateFormat("dd MMMM");
        String printDate = mDF.format(mCalendar.getTime());
        System.out.println(printDate);

        //gestureEvent.setText(reportDate);
        mCalendar.add(Calendar.DAY_OF_MONTH, 6);
        String printDate2 = mDF.format(mCalendar.getTime());
        System.out.println(printDate + " >> " + printDate2);
        return printDate + " >> " + printDate2;        
    }