public static class FrequencyCount {
    public static void main(String[] args){
      java.util.ArrayList<String> dates = new java.util.ArrayList<>();
      dates.add("1991-02-28");
      dates.add("1991-02-28");
      dates.add("1994-02-21");
      java.util.Set<String> uniqueDates = new java.util.HashSet<String>(dates);
      for (String date : uniqueDates) {
        System.out.println(date + ", " + java.util.Collections.frequency(dates, date));
      }
    }
  }