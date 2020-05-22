Calendar calendar = Calendar.getInstance();
calendar.setTime(new Date());
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

//Here you say to java the initial timezone. This is the secret
sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
//Will print in UTC
System.out.println(sdf.format(calendar.getTime()));    

//Here you set to your timezone
sdf.setTimeZone(TimeZone.getDefault());
//Will print on your default Timezone
System.out.println(sdf.format(calendar.getTime()));