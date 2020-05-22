Random rand = new Random();
SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
Calendar calendar = Calendar.getInstance();

List<String> startTimes = new ArrayList<String>();
List<String> endTimes = new ArrayList<String>();

for (int i = 0; i < 50; i++) {
    calendar.set(Calendar.HOUR_OF_DAY, 7 + rand.nextInt(7)); // Starting at 07:00:00
    calendar.set(Calendar.MINUTE, rand.nextInt(60));
    calendar.set(Calendar.SECOND, rand.nextInt(60));
    String Start_Time = df.format(calendar.getTime());

    calendar.add(Calendar.HOUR, rand.nextInt(5));
    calendar.add(Calendar.MINUTE, rand.nextInt(60));
    calendar.add(Calendar.SECOND, rand.nextInt(60));
    String End_Time = df.format(calendar.getTime());
    startTimes.add(Start_Time);
    endTimes.add(End_Time);
}