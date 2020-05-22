public aspect DayBoundaries {

   void around(Date original): set(@DayEnd private Date *) && args(original){
        Calendar c = Calendar.getInstance();
        c.setTime(original);
        c.set(Calendar.HOUR_OF_DAY, 23);
        c.set(Calendar.MINUTE, 59);
        c.set(Calendar.SECOND, 59);
        c.set(Calendar.MILLISECOND, 999);
        proceed(c.getTime());
    };
}