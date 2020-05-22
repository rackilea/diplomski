LocalTime lowerBound = new LocalTime(10, 0);
LocalTime upperBound = new LocalTime(12, 30);

List<DateTime> filtered = new ArrayList<>();

for (DateTime dateTime : originals) {
    LocalTime localTime = new LocalTime(dateTime);
    if (lowerBound.isBefore(localTime) && upperBound.isAfter(localTime)) {
        filtered.add(dateTime);
    }
}