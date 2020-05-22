HashMap<String, AvailableTimeSlot> slots = avalDate.geAavailableDates();
Set keys = slots.keySet();
for (String date : keys) {
  // Here date is 2017-12-31
  AvailableTimeSlot avt = slots.get(date);

  // You can check if except available or not
  if (avt.getExcept() != null) {
    // Read array list of except for that day
    ArrayList<ExceptTimeSlots> except = avt.getExceps();
    // Do whatever you want to do with array
  } else {
    // you can read from and to directlly
    avt.getFrom();
    avt.getTo();
  }
}