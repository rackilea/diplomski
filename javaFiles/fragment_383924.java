//getting local time 
Calendar calendar = Calendar.getInstance(Locale.getDefault());

SimpleDateFormat outputFmt = new SimpleDateFormat("MMM dd, yyy h:mm a zz");
outputFmt.setTimeZone(TimeZone.getTimeZone("GMT")); //set timezone here

//shows calendar time correctly set    
System.out.println(outputFmt.format(calendar.getTime()));