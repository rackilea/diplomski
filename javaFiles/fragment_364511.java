String myStr = "17:23";
SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
Date date = df.parse(myStr ); 
Calendar calendar = Calendar.getInstance();
calendar.setTime(date);
calendar.add(Calendar.MINUTE, 5);
myStr = dateFormat.format(calendar.getTime()); //Now myStr will be 17:28