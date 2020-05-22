Calendar c = Calendar.getInstance();
c.set(Calendar.HOUR_OF_DAY, 13);
c.set(Calendar.MINUTE, 00);
c.set(Calendar.SECOND, 00);

Timer timer = new Timer();
timer.schedule(new TimerTask() {
    @Override
    public void run() {
        //Call your method here
        //setEmail(emailContent, subject);
    }
}, c.getTime(), 86400000);

//24hrs == 86400000ms