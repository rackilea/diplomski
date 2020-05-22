switch (startDate.getDayOfWeek()) {
    case SATURDAY:
    case SUNDAY:
        weekends.add(startDate);
        break;
    default:
        startDate = startDate.plusDays(1);
}