SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

Map<Date, String> activityMap = new TreeMap<Date, String>();
activityMap.put(fmt.parse("2015-04-01 09:00:00"), "Show up at work");
activityMap.put(fmt.parse("2015-04-01 09:05:00"), "Get coffee");
activityMap.put(fmt.parse("2015-04-01 09:15:00"), "Read the news");
activityMap.put(fmt.parse("2015-04-01 10:02:00"), "Smoke break");
activityMap.put(fmt.parse("2015-04-01 10:38:00"), "Watercooler break");
activityMap.put(fmt.parse("2015-04-01 11:45:00"), "Lunch break");

Map<Date, List<String>> dateHourMap = new TreeMap<Date, List<String>>();
Calendar cal = Calendar.getInstance();
for (Map.Entry<Date, String> activity : activityMap.entrySet()) {
    cal.setTime(activity.getKey());
    int year   = cal.get(Calendar.YEAR);
    int month  = cal.get(Calendar.MONTH);
    int day    = cal.get(Calendar.DAY_OF_MONTH);
    int hour   = cal.get(Calendar.HOUR_OF_DAY);
    int minute = cal.get(Calendar.MINUTE);
    int second = cal.get(Calendar.SECOND);
    cal.clear();
    cal.set(year, month, day, hour, 0);
    Date dateHour = cal.getTime();
    List<String> list = dateHourMap.get(dateHour);
    if (list == null)
        dateHourMap.put(dateHour, list = new ArrayList<String>());
    list.add(String.format("%02d:%02d %s", minute, second, activity.getValue()));
}

fmt = new SimpleDateFormat("yyyy-MM-dd HH");
for (Map.Entry<Date, List<String>> entry : dateHourMap.entrySet())
    System.out.println(fmt.format(entry.getKey()) + ": " + entry.getValue());