for(String timezone : Timezone.getAvailableIDs()) {
    Calendar cal = new GregorianCalendar(timezone);

    // or do whatever you want with these
    System.out.println("AM_PM: " + calendar.get(Calendar.AM_PM));
    System.out.println("HOUR: " + calendar.get(Calendar.HOUR));
    System.out.println("HOUR_OF_DAY: " + calendar.get(Calendar.HOUR_OF_DAY));
    System.out.println("MINUTE: " + calendar.get(Calendar.MINUTE));
    System.out.println("SECOND: " + calendar.get(Calendar.SECOND));
    System.out.println("MILLISECOND: " + calendar.get(Calendar.MILLISECOND));
    System.out.println("ZONE_OFFSET: " + (calendar.get(Calendar.ZONE_OFFSET)/(60*60*1000)));
}