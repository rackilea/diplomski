String timestamp = "1431941838000";
    long time = Long.valueOf(timestamp);
    Date currentDate = new Date(time);
    DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

    TimeZone zoneNewYork = TimeZone.getTimeZone("America/New_York");
    df.setTimeZone(zoneNewYork);
    String finale = df.format(currentDate);
    System.out.println(finale);

    TimeZone zoneEst = TimeZone.getTimeZone("EST");
    df.setTimeZone(zoneEst);
    finale = df.format(currentDate);
    System.out.println(finale);