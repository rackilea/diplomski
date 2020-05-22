SimpleDateFormat sdf = new SimpleDateFormat("yyyy:MM:dd:HH:mm");
String currentDateandTime = sdf.format(new Date());

Date date = sdf.parse(currentDateandTime);
Calendar calendar = Calendar.getInstance();
calendar.setTime(date);
calendar.add(Calendar.HOUR, 1);

System.out.println("Time here "+calendar.getTime());