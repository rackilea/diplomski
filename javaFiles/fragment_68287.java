public static String getEndDate() {
    Calendar date = Calendar.getInstance();
    date.setTime(new Date());
    Format f = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH); // Locale
    date.add(Calendar.YEAR,1);
    return f.format(date.getTime());
}