LocalDateTime d = LocalDateTime.parse("2016-10-31 23:59:59", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

System.out.println("toString: " + d.toString());
//toString: 2016-10-31T23:59:59                                                                                                                                                                                                                           
System.out.println("format:   " + d.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
//format:   2016-10-31 23:59:59