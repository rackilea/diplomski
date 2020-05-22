String theDate = inputDate.getText().toString();
SimpleDateFormat firstFormatter = new SimpleDateFormat("MM-dd-yyyy");
try {
      Date date = firstFormatter .parse(theDate );
      SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z");
      String submitDate = sd.format(date);

    } catch (ParseException e) {
      e.printStackTrace();
    }