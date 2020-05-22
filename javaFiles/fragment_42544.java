TimeInterval time = new TimeInterval("00:00:00.000");

try {
    for (int i = 0; i < 24; i++) {
      time = time.add(new TimeInterval("01:00:00.123"));
    }

    System.out.println(time.toString());
} catch (ParseException e) {
    e.printStackTrace();
}