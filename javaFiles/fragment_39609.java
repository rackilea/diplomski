String timeInterval = "2018-05-03T08:00Z/2018-05-04T04:00Z";
    String[] allTime = timeInterval.split("/");
    if (allTime.length != 2) {
        throw new IllegalStateException("Wrong number of datetimes, should be 2");
    }
    OffsetDateTime dateTimeStart = OffsetDateTime.parse(allTime[0]);
    OffsetDateTime dateTimeEnd = OffsetDateTime.parse(allTime[1]);
    OffsetDateTime current = dateTimeStart;
    while (current.isBefore(dateTimeEnd)) {
        OffsetDateTime next = current.plusHours(1);
        System.out.println("" + current + '/' + next);
        current = next;
    }
    System.out.println("Time End: " + dateTimeEnd);