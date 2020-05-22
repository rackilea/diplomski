String date = "12:00PM";
if (date.indexOf("PM")!=-1)//its pm
{
    int pmindex = date.indexOf("PM");
    int separator=date.indexOf(":");
    int hour = Integer.parseInt(date.substring(0, separator));
    int minute = Integer.parseInt(date.substring(separator+1,pmindex));
    hour = hour+12;
    System.out.println("Time is: " + hour);
}