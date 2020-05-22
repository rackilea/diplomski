public static final Date MY_DATE;

static {
    try {
       MY_DATE = Util.getDateFromString("20000101");
    } catch (ParseException e) {
       ...
    }
}