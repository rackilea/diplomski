ArrayList<String> week1 = new ArrayList<>(); // this week
    ArrayList<String> week2 = new ArrayList<>(); // last week
    ArrayList<String> week3 = new ArrayList<>(); // weeks ago
    ArrayList<String> week4 = new ArrayList<>(); // weeks ago
    Calendar calendar=Calendar.getInstance();
    for (int i = Calendar.SUNDAY; i <= Calendar.SATURDAY; i++) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        calendar.set(Calendar.DAY_OF_WEEK, i);
        week1.add(sdf.format(calendar.getTime()));
    }
    calendar.add(Calendar.WEEK_OF_YEAR,-1);
    for (int i = Calendar.SUNDAY; i <= Calendar.SATURDAY; i++) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        calendar.set(Calendar.DAY_OF_WEEK, i);
        week2.add(sdf.format(calendar.getTime()));
    }
    calendar.add(Calendar.WEEK_OF_YEAR,-1);
    for (int i = Calendar.SUNDAY; i <= Calendar.SATURDAY; i++) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        calendar.set(Calendar.DAY_OF_WEEK, i);
        week3.add(sdf.format(calendar.getTime()));
    }
    calendar.add(Calendar.WEEK_OF_YEAR,-1);
    for (int i = Calendar.SUNDAY; i <= Calendar.SATURDAY; i++) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        calendar.set(Calendar.DAY_OF_WEEK, i);
        week4.add(sdf.format(calendar.getTime()));
    }