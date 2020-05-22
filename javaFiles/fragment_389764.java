private Date convertFromString(String birthdate) {
            Date date = null;
           SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.UK);

            try {
                Calendar cal = Calendar.getInstance(); // <-- this,
                cal.setTime(format.parse(birthdate)); // and that line gets skipped by debugger step
                System.out.print(cal); // this line gets executed
                return cal.getTime();   
            } catch (ParseException exception) {
                System.out.print("wtf??");
            }
        return null;
   }