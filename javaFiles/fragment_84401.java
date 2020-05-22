Date time = new Date(39733000L); // 1970-01-01T12:02:13
Date date = new Date(1462399200000L); // 2016-05-05T00:00:00
Date dateTime = new Date(1462442533000L); // 2016-05-05T12:02:13

Stream.of(time, date, dateTime)
        .map(d -> toJava8Time(d))
        .map(t -> formatter.format(t).trim())
        .forEach(System.out::println);

//Outputs "12:02:13", "2016-05-05", "2016-05-05 12:02:13"