class DateFormatter{

    private static ThreadLocal<SimpleDateFormat> outDateFormatHolder = new ThreadLocal<SimpleDateFormat>() {
    @Override
    protected SimpleDateFormat initialValue() {
        return new SimpleDateFormat("MM/dd/yyyy");
    }
};

private static ThreadLocal<SimpleDateFormat> inDateFormatHolder = new ThreadLocal<SimpleDateFormat>() {
    @Override
    protected SimpleDateFormat initialValue() {
        return new SimpleDateFormat("yyyyMMdd");
    }
};

public static String formatDate(String date) throws ParseException { 
    return outDateFormatHolder.get().format(
            inDateFormatHolder.get().parse(date));
}        
}