String input = "Sun Dec 31 23:30:00 CET 1889";
SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
TimeZone tz = TimeZone.getTimeZone("Europe/Paris");
sdf.setTimeZone(tz);
Date d = sdf.parse(input);
ZoneOffset offset = ZoneOffset.ofTotalSeconds(tz.getOffset(d.getTime()) / 1000);

System.out.println(d); // Tue Dec 31 23:30:00 CET 1889

LocalDateTime ldt = LocalDateTime.ofInstant(d.toInstant(), offset);
System.out.println("ldt=" + ldt); // 1889-12-31T23:30