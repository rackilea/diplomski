long now = System.currentTimeMillis();
    Calendar christmas = Calendar.getInstance();
    christmas.set(Calendar.MONTH, Calendar.DECEMBER);
    christmas.set(Calendar.DAY_OF_MONTH, 25);
    long untilChristmas = christmas.getTimeInMillis() - now;

    DateFormat df = new SimpleDateFormat("dd-kk-mm-ss");
    Date date = new Date(untilChristmas);

    System.out.println(df.format(date));