ParseQuery<ParseAttendance> pq = ParseQuery.getQuery(ParseAttendance.class);
pq.setLimit(1000);
pq.setSkip((page - 1) * pq.getLimit());
pq.whereEqualTo("studentId", studentId);
pq.orderByDescending("year");
pq.addDescendingOrder("month");
pq.addDescendingOrder("day");
List<ParseAttendance> lst = pq.find();