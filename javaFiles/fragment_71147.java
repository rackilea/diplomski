String startdate = "2015-11-30";
    String enddate = "2016-1-30";

    DateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
    DateFormat outputFormater = new SimpleDateFormat("MMM-yyyy");

    Calendar beginCalendar = Calendar.getInstance();
    Calendar finishCalendar = Calendar.getInstance();

    try {
          beginCalendar.setTime(formater.parse(startdate));
          finishCalendar.setTime(formater.parse(enddate));

          if (beginCalendar.get(Calendar.MONTH) != finishCalendar.get(Calendar.MONTH)){
              beginCalendar.set(Calendar.DAY_OF_MONTH, 1);
              finishCalendar.set(Calendar.DAY_OF_MONTH, 2);
          }

          do {
                // add one month to date per loop
                String month_year = outputFormater.format(beginCalendar.getTime());
                Log.d("Date_Range", month_year);
                beginCalendar.add(Calendar.MONTH, 1);
          } while (beginCalendar.before(finishCalendar));
    } catch (ParseException e) {
         e.printStackTrace();
    }