HashMap<String, String> linkMap = new HashMap<String, String>();
    linkMap.put("Monday", "some link");
    linkMap.put("Tuesday", "some other link");
    // ...
    String weekDay;
    String link;
    SimpleDateFormat dayFormat = new SimpleDateFormat("EEEE", Locale.US);
    Calendar calendar = Calendar.getInstance();
    weekDay = dayFormat.format(calendar.getTime());
    link = linkMap.get(weekDay);