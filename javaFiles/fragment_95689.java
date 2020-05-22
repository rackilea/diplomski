public boolean makeAppointment(String desc, int duration, int hour) {

  //...

  for (int i = booleanHour; i < booleanHour + duration; i++) { 
    if (!availability[i]) {
      System.out.println("This has hour been booked, please choose another time. We open at 9am, and close at 5pm.");
      return false;
    }
  } 

  for (int b = booleanHour; b < booleanHour + duration; b++) {
      availability[b] = false; // here we are making all hours booked no matter they are booked or not already
      Appointment appoint = new Appointment(desc, duration, b + 9);
      schedule.put(b + 9, appoint);
  }

  return true;

  //...

}