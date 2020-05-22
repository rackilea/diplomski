public static void main(String[] args) throws Exception {
    DateFormat format = new SimpleDateFormat("HH:mm:ss a");
    format.setTimeZone(TimeZone.getTimeZone("UTC"));
    for(String fracStr : args) {
        double frac = Double.parseDouble(fracStr);
        long day = (long) Math.floor(frac);
        frac = frac - day;
        Date time = new Date((long) ( 86400000l * frac));
        System.out.println(fracStr+" -> "+format.format(time));
    }
}