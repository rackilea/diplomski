public List<LocalDate> findWeekendsBetween(long startTime, long endTime) {
    LocalDate startDate = LocalDate.ofEpochDay(startTime);
    LocalDate endDate = LocalDate.ofEpochDay(endTime);

    System.out.println("Starting from " + startDate);
    System.out.println("Ending at " + endDate);

    List<LocalDate> weekends = new ArrayList<>(25);
    while (startDate.isBefore(endDate) || startDate.equals(endDate)) {
        switch (startDate.getDayOfWeek()) {
            case SATURDAY:
                weekends.add(startDate);
                startDate = startDate.plusDays(2);
                break;
            default:
                startDate = startDate.plusDays(1);
        }
    }
    return weekends;
}