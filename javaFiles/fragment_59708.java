// February 18th 2018 at midnight, DST ends in Sao Paulo
// local times from 23:00 to 23:59 at 17th exist twice
LocalDateTime d = LocalDateTime.of(2018, 2, 17, 23, 0, 0, 0);
// by default, it gets the offset before DST ends
ZonedDateTime beforeDST = d.atZone(zone);
System.out.println(beforeDST); // before DST end: 2018-02-17T23:00-02:00[America/Sao_Paulo]

// get the offset after DST ends
ZonedDateTime afterDST = beforeDST.withLaterOffsetAtOverlap();
System.out.println(afterDST); // after DST end: 2018-02-17T23:00-03:00[America/Sao_Paulo]