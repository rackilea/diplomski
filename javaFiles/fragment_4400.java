public static void main(String[] args) {
    String pattern = "yyyy-MM-dd HH:mm:ss";
    Date date = new Date();
    String defaultFmt = new SimpleDateFormat(pattern).format(date);

    for (Locale locale : Locale.getAvailableLocales()) {
        String localeFmt = new SimpleDateFormat(pattern, locale).format(date);
        if (!localeFmt.equals(defaultFmt)) {
            System.out.println(locale + " " + localeFmt);
        }
    }
}