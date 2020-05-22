DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
String timeString = "2016-02-18T20:15:37.421Z";
Date date;
try {
        date = dateFormat.parse(timeString);
        System.out.println(date);
    } catch (ParseException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }