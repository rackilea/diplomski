DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("h:mm a", Locale.ENGLISH);

    String s1 = "11:04 AM";
    String s2 = "1:00 PM";
    LocalTime time1 = LocalTime.parse(s1, timeFormatter);
    LocalTime time2 = LocalTime.parse(s2, timeFormatter);
    if (time1.isBefore(time2)) {
        System.out.println("time1 < time2");
    } else {
        System.out.println("time1 >= time2");
    }