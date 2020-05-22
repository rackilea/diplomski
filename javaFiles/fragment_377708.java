You can do something like this, when the user starts quiz and enters into your first level, then inside onCreate take start time like this:

        Calendar calendar;
        SimpleDateFormat df;
        String template = "yyyy-MM-dd HH:mm:ss";
        calendar = Calendar.getInstance();
        df = new SimpleDateFormat(template, Locale.getDefault());

        //this will give you the start time
        String startTime = df.format(calendar.getTime());

        //when user finishes up the level again record the finish time
        String finishTime = df.format(calendar.getTime());

       //then compare the two times
        Date d1 = null;
        Date d2 = null;
        try {
            d1 = df.parse(startTime);
            d2 = df.parse(finishTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }

       //in milliseconds
        long diff = d2.getTime() - d1.getTime();

        long diffSeconds = diff / 1000;
        long diffMinutes = diff / (60 * 1000);
        long diffHours = diff / (60 * 60 * 1000);