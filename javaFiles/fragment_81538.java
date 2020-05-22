String date="12/01/2010";
String incDate;
SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
Calendar c = Calendar.getInstance();
c.setTime(sdf.parse(date));
int maxDay = c.getActualMaximum(Calendar.DAY_OF_MONTH);
for(int co=0; co<maxDay; co++){
    c.add(Calendar.DATE, 1); 
    incDate = sdf.format(c.getTime());
}