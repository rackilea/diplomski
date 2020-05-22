List<Period> periodList = new ArrayList<>();
Period p = null;
LocalDateTime prev = null;
DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
for (String s : datesList) {
    if (prev == null) { // starting new period 
        prev = LocalDateTime.parse(s, fmt);
        p = new Period();
        p.setStartDate(prev);
    } else { // in the middle of a period
        LocalDateTime date = LocalDateTime.parse(s, fmt);
        // check the difference in days
        // convert to LocalDate to ignore hours in the comparison
        if (ChronoUnit.DAYS.between(prev.toLocalDate(), date.toLocalDate()) > 1) {
            // difference is more than 1 day, period ended
            p.setEndDate(prev);
            periodList.add(p);

            // start new period
            p = new Period();
            p.setStartDate(date);
            prev = date;
        } else {
            prev = date;
        }
    }
}
// check last period
if (p != null && p.getEndDate() == null) {
    p.setEndDate(p.getStartDate());
    periodList.add(p);
}