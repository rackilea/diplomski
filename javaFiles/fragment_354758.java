private Object lock = new Object();
// ...
try {
    synchronized (lock) {
        // Either "2016-03-23T18:21+01:00" or "2016-03-23T18:21Z"
        // will be correctly parsed (mind the different meaning though)
        Date date = dateFormat.parse("2016-03-23T18:21Z");
        System.out.println(date); // Wed Mar 23 19:21:00 CET 2016
    }
} catch (ParseException e) {
    LOG.error("Date time parsing exception", e);
}