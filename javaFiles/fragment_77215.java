Calendar c = duedateCalendar.get();
// c is now a copy of the reference held internally by duedateCalendar

c.set(Calendar.YEAR,2017);
// this updates the Calendar object referenced both by c and internally
// by duedateCalendar. Since the YEAR field in Calendar is just a primitive,
// and is not an observable value in the JavaFX sense, nothing is notified
// of the change

duedateCalendar.set(c);
// the value passed to set here is equal (indeed identical) to the value
// held internally by duedateCalendar (since it's an actual copy of the
// same reference). Internally, duedateCalendar will compare the parameter
// to the value it already holds, will see that they are the same, and
// so will take no action (including not notifying listeners)