String oldTime = "2000"; // replace with parser.nextText();

Date date = new SimpleDateFormat("HHmm").parse(oldTime);

String newTime = new SimpleDateFormat("HH:mm").format(date);
String newTime2 = new SimpleDateFormat("a. HH:mm").format(date);

System.out.println(newTime);
System.out.println(newTime2);

//hospital.setDutyTime1c(newTime)
//or
//hospital.setDutyTime1c(newTime2);