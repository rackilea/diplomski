String time1 = "23:05:38";
    LocalTime t1 = LocalTime.parse(time1);
    String time2 = "12:36:07";
    LocalTime t2 = LocalTime.parse(time2);
    Duration diff = Duration.between(t2, t1);
    System.out.println(diff.toHours());