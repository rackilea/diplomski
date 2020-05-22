while (newDate.compareTo(endDate1) < 0) {
        c.setTime(newDate);
        c.add(Calendar.DATE, 1);
        newDate = c.getTime();
        shiftDate.setDateString(c.getTime().toString());
        shiftDateList.add(shiftDate);
    }