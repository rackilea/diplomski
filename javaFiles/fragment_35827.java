import java.util.Calendar;

// class definition here, etc...

    Calendar cal = Calendar.getInstance();
    cal.set(1985, 1, 8); // Assumes MM/dd/yyyy
    //cal.set(1985, 8, 1); // Assumes dd/MM/yyyy
    // cal.getTime() returns a Date object
    a.setDateOfBirth(cal.getTime());