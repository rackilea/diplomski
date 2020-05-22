Calendar mCalendar = new GregorianCalendar(); 
        mCalendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        SimpleDateFormat mDF = new SimpleDateFormat("dd MMMM");
        String printDate = mDF.format(mCalendar.getTime());
        mCalendar.add(Calendar.DAY_OF_MONTH, 6);
        String printDate2 = mDF.format(mCalendar.getTime());

        System.out.println(printDate + " >> " + printDate2);
        gestureEvent.setText(printDate + " >> " + printDate2);