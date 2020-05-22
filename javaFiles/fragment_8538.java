Date now = new Date();
Date today14pm = new Date();
Calendar calendar = Calendar.getInstance();
calendar.setTime(today14PM);
calendar.set(Calendar.HOUR_OF_DAY, 14);
calendar.set(Calendar.MINUTES, 0);
calendar.set(Calendar.SECONDS, 0);
calendar.set(Calendar.MILLISECONDS, 0);
today14pm = Calendar.getTime();

if(now.after(today14pm)) {
    //Generate tomorrow's date    
} else {
    //Generate today's date
}