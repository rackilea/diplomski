public void someMethodToSetJob() {
    final String cronTabSchedule = "0 0 3 ? * MON-FRI *";
    final Calendar cal = Calendar.getInstance();
    cal.add(Calendar.HOUR_OF_DAY, 3);
    cal.set(Calendar.SECOND, 0);

    final Calendar expiry = Calendar.getInstance();
    expiry.set(Calendar.MONTH, 11);
    expiry.set(Calendar.DATE, 31);
    expiry.set(Calendar.YEAR, 9999);
    expiry.set(Calendar.SECOND, 0);

    processBackgroundProcessCheck(cal.getTime(), cronTabSchedule, expiry.getTime());
}