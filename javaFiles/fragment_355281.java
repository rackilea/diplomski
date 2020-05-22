private void selectedDateChanged(CalendarView view, int year, int month, int dayOfMonth){
        //note: _Calendar is set to the view when activity loads hence the
        //the reason for not using view.getDate();
        Long timeSinceEpoch = _Calendar.getDate();

        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTimeInMillis(timeSinceEpoch);

        //Notice instead of calling cal.DAY_OF_MONTH directly
        //I now call calendar.get(Calendar.DAY_OF_MONTH)
        System.out.println(String.format("With gregorian calendar \n Day: %s \n Month: %s \n Year: %s",
                calendar.get(Calendar.DAY_OF_MONTH), calendar.get(Calendar.MONTH), calendar.get(Calendar.YEAR)));

    }