String date = "2011-05-01"; 
SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
Calendar c = Calendar.getInstance();
c.setTime(df.parse(date));
c.add(Calendar.DATE, 1);  // how many days you want to add like here 1
String addeddate = df.format(c.getTime());