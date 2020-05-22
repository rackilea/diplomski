String startTime = "10:00";
    String endTime = "12:00";
    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
    Date d1 = sdf.parse(startTime);
    Date d2 = sdf.parse(endTime);
    long elapsed = d2.getTime() - d1.getTime(); 
    System.out.println(elapsed);