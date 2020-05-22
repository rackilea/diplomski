SntpClient client = new SntpClient();
int timeout = 50000;
if (client.requestTime("time-a.nist.gov", timeout)) {
    long time = client.getNtpTime();
    Calendar calendar = Calendar.getInstance();
    calendar.setTimeInMillis(time);
    calendar.getTime();  // this should be your date
}