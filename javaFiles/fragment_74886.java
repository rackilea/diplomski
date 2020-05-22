SharedPreferences sp = context.getSharedPreferences(Constants.SP_SETTINGS,Context.MODE_PRIVATE);
    String start = sp.getString(Constants.PARAM_SLEEP_MODE_START,null);
    String end = sp.getString(Constants.PARAM_SLEEP_MODE_END,null);
    if (start==null || end ==null) return null;
    DateTime now = new DateTime(new Date());
    Days days = Days.daysBetween(new DateTime(new Date(0)).toLocalDate(),now.toLocalDate());
    DateTimeFormatter formatter = DateTimeFormat.forPattern("HH:mm");
    DateTime begin = formatter.parseDateTime(start).plusDays(days.getDays());
    DateTime finish = formatter.parseDateTime(end).plusDays(days.getDays());
    if (begin.isAfter(finish)) {
        if (now.isBefore(finish)) begin = begin.minusDays(1);
        else  finish = finish.plusDays(1);
    } else {
        if (now.isAfter(finish)) {
            begin = begin.plusDays(1);
            finish = finish.plusDays(1);
        }
    }
    Interval interval = new Interval(begin,finish);
    return interval.contains(now);