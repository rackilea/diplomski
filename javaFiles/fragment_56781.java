public List<Date> generateRangeDates(Date firstDate, Date lastDate) {
      List<Date> dates = new ArrayList<Date>();
      for(long t = firstDate.getTime(); t <= lastDate.getTime(); t += 24 * 60 * 60 * 1000)
          dates.add(new Date(t));
      return dates;
 }