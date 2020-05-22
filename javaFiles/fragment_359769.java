ArrayList<Integer> toCampus = new ArrayList<>(
                Arrays.asList(623, 1234, 1734, 2100)
);

for (int time : toCampus) {
    String value = String.format("%04d", time);
    LocalTime lt = LocalTime.parse(value, DateTimeFormatter.ofPattern("HHmm"));
    System.out.println(DateTimeFormatter.ofPattern("hh:mm a").format(lt));
}