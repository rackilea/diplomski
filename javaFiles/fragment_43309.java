public static void main(String[] args) throws ParseException {
    List<String> hhMmPeriods = new ArrayList<String>();
    hhMmPeriods.add("01:11");
    hhMmPeriods.add("11:00");
    hhMmPeriods.add("00:55");
    hhMmPeriods.add("21:47");

    System.out.println(TimeUtils.addHhMmPeriods(hhMmPeriods)); // => 01:10:53
  }