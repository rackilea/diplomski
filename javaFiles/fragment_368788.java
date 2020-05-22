public static void main(String[] args) throws Exception {
    final TimeZone madrid = TimeZone.getTimeZone("Europe/Madrid");
    final TimeZone canaries = TimeZone.getTimeZone("Atlantic/Canary");
    final long now = System.currentTimeMillis();

    System.out.println(madrid.getOffset(now));
    System.out.println(canaries.getOffset(now));
}