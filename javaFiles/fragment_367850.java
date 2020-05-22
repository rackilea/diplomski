RangeSetHashMap<Integer, Time> sensorIDsWithTimeRange = new RangeSetHashMap<>();
sensorIDsWithTimeRange.put(0, Range.closedOpen(valueOf("12:30:00"), valueOf("12:40:00")));
sensorIDsWithTimeRange.put(0, Range.closedOpen(valueOf("17:09:42"), valueOf("23:06:33")));
sensorIDsWithTimeRange.put(1, Range.closedOpen(valueOf("04:13:56"), valueOf("04:14:02")));
System.out.println(sensorIDsWithTimeRange);
sensorIDsWithTimeRange.put(0, Range.closedOpen(valueOf("02:11:12"), valueOf("12:45:19")));
System.out.println(sensorIDsWithTimeRange);