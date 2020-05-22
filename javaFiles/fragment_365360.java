public static void main(String[] args) {
    long duration = 1209622L;
    long days = TimeUnit.SECONDS.toDays(duration);
    duration -= TimeUnit.DAYS.toSeconds(days);

    long hours = TimeUnit.SECONDS.toHours(duration);
    duration -= TimeUnit.HOURS.toSeconds(hours);

    long minutes = TimeUnit.SECONDS.toMinutes(duration);
    duration -= TimeUnit.MINUTES.toSeconds(minutes);

    long seconds = TimeUnit.SECONDS.toSeconds(duration);

    StringBuilder msg = new StringBuilder( );
    if (days!=0) {
        msg.append( days+" day(s)");
    }
    if (hours!=0) {
        msg.append( hours+" hours(s)");
    }
    if (minutes!=0) {
        msg.append( minutes+" minutes(s)");
    }
    if (seconds!=0) {
        msg.append( seconds+" seconds(s)");
    }
    System.out.println(msg.toString());
}