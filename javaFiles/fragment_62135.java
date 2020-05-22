Calendar calendar = Calendar.getInstance();
SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");

for (int index = 1; index <= 5; index++) {
    calendar.add(Calendar.DATE, -1);
    System.out.println(dateFormat.format(calendar.getTime()));
}