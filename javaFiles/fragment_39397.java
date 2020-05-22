// This example works
String dateStart = "2045";
String dateStop = "2300";

// This example doesnt work
//String dateStart = "2330";
//String dateStop = "0245";

// Custom date format
SimpleDateFormat format = new SimpleDateFormat("HHmm");  

Date d1 = null;
Date d2 = null;
try {
    d1 = format.parse(dateStart);
    d2 = format.parse(dateStop);
} catch (Exception e) {
    e.printStackTrace();
}

// MY ADDITION TO YOUR CODE STARTS HERE
if(d2.before(d1)){
    Calendar c = Calendar.getInstance(); 
    c.setTime(d2); 
    c.add(Calendar.DATE, 1);
    d2 = c.getTime();
}
// ENDS HERE

long diff = d2.getTime() - d1.getTime();
long minutes = TimeUnit.MILLISECONDS.toMinutes(diff);                      
System.out.println("Time in minutes: " + minutes + " minutes.");