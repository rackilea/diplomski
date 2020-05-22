SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm a");

date1 = simpleDateFormat.parse("08:00 AM");
date2 = simpleDateFormat.parse("04:00 PM");

long difference = date2.getTime() - date1.getTime(); 
days = (int) (difference / (1000*60*60*24));  
hours = (int) ((difference - (1000*60*60*24*days)) / (1000*60*60)); 
min = (int) (difference - (1000*60*60*24*days) - (1000*60*60*hours)) / (1000*60);
hours = (hours < 0 ? -hours : hours);
Log.i("======= Hours"," :: "+hours);