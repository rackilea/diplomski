Date date = new Date();

System.out.println(DateTimeFormatter.ISO_INSTANT.format(date.toInstant()));
// output: 2015-11-22T14:46:08.776Z

System.out.println(DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(
       date.toInstant().atZone(ZoneId.systemDefault())));
// output: 2015-11-22T15:46:08.776+01:00

System.out.println(DateTimeFormatter.ISO_OFFSET_DATE_TIME
                                    .withZone(ZoneId.systemDefault())
                                    .format(date.toInstant()));
// output: 2015-11-22T15:46:08.776+01:00