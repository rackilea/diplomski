final List<Hall_calendar> res = (List<Hall_calendar>) q.list();
for (final Hall_calendar hall_calendar : res) {
    hall_calendar.setHall_availability("N");
    //no need to explicitly save these..
}
session.save(hbc);