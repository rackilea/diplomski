String dt = "2015-04-13";  // Current monday date
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
Calendar c = Calendar.getInstance();
c.setTime(sdf.parse(dt));
if(next){
  c.add(Calendar.DATE, 7);  // for next Monday
}else{ 
  c.add(Calendar.DATE, -7);  // for previous Monday
}
dt = sdf.format(c.getTime());  // dt is now the new date