String x = "2019-09-30 17:46:04.600";
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date date = formatter.parse(x);
        System.out.println(date);
        System.out.println(formatter.format(date));
        outputFormat.setTimeZone(TimeZone.getTimeZone("America/New_York"));
        System.out.println(outputFormat.format(date));