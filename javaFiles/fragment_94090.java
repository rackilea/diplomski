org.postgresql.util.PGInterval i =
    (org.postgresql.util.PGInterval) rs.getObject("time_interval");

// gives something like "1 years 0 mons 0 days 2 hours 0 mins 0.00 secs"
System.out.println(i);

// gives something like "2"
System.out.println(i.getHours());