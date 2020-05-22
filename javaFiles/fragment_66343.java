int timeToGrow = 1352364;
int secs = timeToGrow % 60;
int mins = (timeToGrow / 60) % 60;
int hours = ((timeToGrow / 60) / 60) % 24;
int days = (((timeToGrow / 60) / 60) / 24) % 7;
int weeks = (((timeToGrow/60)/60)/24)/7;
System.out.println(weeks + " Weeks "+ days + " Days " + hours + " Hours " + mins + " Minutes " + secs + " Seconds.");