private static ThreadLocal<SimpleDateFormat> localIsoDateFormat = new ThreadLocal<SimpleDateFormat>() {

    @Override
    protected SimpleDateFormat initialValue() {
        return new SimpleDateFormat("yyyy-MM-dd");
    }
}