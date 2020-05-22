List<LocalDate> localDatesList = new ArrayList<LocalDate>();
localDatesList.add(new LocalDate());
localDatesList.add(new LocalDate().plusDays(1));
localDatesList.add(new LocalDate().plusDays(2));
localDatesList.add(new LocalDate().plusMonths(1));
localDatesList.add(new LocalDate().plusMonths(2));

List<String> tempDatesList = new ArrayList(localDatesList.size());
tempDatesList.add("Select a value");
for (LocalDate date : localDatesList) {
    tempDatesList.add(date.toString());
}

String[] formattedDates = tempDatesList.toArray(new String[localDatesList.size()]);
for (String dates : formattedDates) {
    System.out.println(dates);
}