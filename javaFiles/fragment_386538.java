Calendar calendar = ...
//...
date = calendar.getTime();
Timestamp epochTimeStamp = new Timestamp(date.getTime());
SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
try {
    System.out.println(sdf.format(date));
    System.out.println(sdf.format(epochTimeStamp));
} catch (Exception e) {
    //handle it!
}