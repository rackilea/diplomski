LocalDate from = interval.getStart().toLocalDate();
LocalDate to = interval.getEnd().toLocalDate();
List<LocalDate> lds = new ArrayList<>(Days.daysBetween(from, to).getDays());
for(LocalDate c = from ; c.isBefore(to) || c.isEqual(to) ; 
      c = c.plusDays(1)) {
    lds.add(c);
}