List<Date> dateList = new ArrayList<Date>();
    //add your dates here
    Collections.sort(dateList);
    int count = 0;
    Date previousDate = null;
    List<Date> datesGroup = new ArrayList<Date>();
    for (Date date : dateList) {
        if (previousDate == null) {
            previousDate = new Date();
            count++;
        } else {
            long diff = date.getTime() - previousDate.getTime();
            if (diff == 86400000) {
                count++;
            } else {
                count = 0;
                datesGroup.clear();
            }
        }
        datesGroup.add(date);
        previousDate.setTime(date.getTime());
        if (count == 6) {
            break;
        }
    }
    for (Date dates : datesGroup) {
        System.out.println("dates sorted : " + dates);
    }