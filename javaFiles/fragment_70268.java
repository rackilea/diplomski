long movingAverage = 0;

    // 1. define offset
    LocalTime offset = new LocalTime("12:00:00");
    long offsetMillis = offset.getMillisOfDay();

    for (String date : times) {
        long sampleMillis = new LocalTime(date).getMillisOfDay();

        // align to offset
        if (sampleMillis < offsetMillis)
            sampleMillis += DateTimeConstants.MILLIS_PER_DAY;

        long diff = sampleMillis - offsetMillis;

        // 2. use moving average
        movingAverage = movingAverage + diff / times.size();
    }

    // 3. avoid LocalTime(long) constructor
    LocalTime result = offset.plusMillis((int) movingAverage);
    System.out.println(result); // 23:48:54.329