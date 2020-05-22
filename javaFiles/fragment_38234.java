LocalDate start = LocalDate.parse("2016-02-09");
LocalDate end = LocalDate.parse("2016-02-12");
if (start.isAfter(end))  {
    return Collections.emptyMap();
}

LocalDate current = start;
Map<Integer, Boolean> map = new TreeMap<>();

do {
    map.put(current.getDayOfWeek(), Boolean.TRUE);
    current = current.plusDays(1);
} while (!current.isAfter(end) && map.size() < 7);

LocalDate ref = new LocalDate(2016, 2, 7); // sunday
DateTimeFormatter f = DateTimeFormat.forPattern("E").withLocale(Locale.US);
StringBuilder sb = new StringBuilder();

for (int dayOfWeek : map.keySet()) {
    String output = f.print(ref.plusDays(dayOfWeek));
    sb.append(", ");
    sb.append(output);
}
System.out.println(sb.delete(0, 2).insert(0, "[").append(']').toString());
// [Tue, Wed, Thu, Fri]
return map;