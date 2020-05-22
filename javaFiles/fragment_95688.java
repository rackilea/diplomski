for (int i = booleanHour; i < booleanHour + duration; i++) { 
    if (availability[i] == false) {
      System.out.println("This has hour been booked, please choose another time. We open at 9am, and close at 5pm.");
      System.out.println(check);
      check = false;
      return false;
    } // this is the end of IF not FOR - only first element was checked!
    if (check) { // yup it's true because 10 is free...
      for (int b = booleanHour; b < booleanHour + duration; b++) {
        availability[b] = false; // here we are making all hours booked no matter they are booked or not already
        Appointment appoint = new Appointment(desc, duration, b + 9);
        schedule.put(b + 9, appoint);
      }
      return true;
    }
  } // and finally this is the end of FOR but it's too late