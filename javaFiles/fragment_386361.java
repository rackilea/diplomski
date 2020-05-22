String weekdaygen(String s) {
        if (s.equals("Mon")) {
            s=s.replace("mon", "MONDAY");
        }
        if (s.equals("Tue")) {
           s= s.replace("Tue", "TUESDAY");
        }
        if (s.equals("Wed")) {
            s=s.replace("Wed", "WEDNESDAY");
        }
        if (s.equals("Thu")) {
            s=s.replace("Thu", "THURSDAY");
        }
        if (s.equals("Fri")) {
            s=s.replace("Fri", "FRIDAY");
        }
        if (s.equals("Sat")) {
            s=s.replace("Sat", "SATURDAY");
        }
        if (s.equals("Sun")) {
            s=s.replace("Sun", "SUNDAY");
        }
        return s;

    }