if (myApp.getArrCalendarModelList()!=null){
    calItem = myApp.getArrCalendarModelList();
    for (int i=0;i<calItem.size();i++){
        String string = calItem.get(i).date_course;
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        Date date = format.parse(string);
        calItem.get(i).setDate(date);
    }
    Collections.sort(calItem, new Comparator<Item>() {
      public int compare(Item o1, Item o2) {
          return o1.getDate().compareTo(o2.getDate());
      }
    });
}