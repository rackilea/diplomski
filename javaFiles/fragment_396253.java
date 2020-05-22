final String gameDate = "2016-03-19T19:45:00Z";
final SimpleDateFormat apiFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
apiFormat.setTimeZone(TimeZone.getTimeZone("CET"));
final Date dateOfGame = apiFormat.parse(gameDate);
final long millis = dateOfGame.getTime() - System.currentTimeMillis();
System.out.println(dateOfGame.getTime() - System.currentTimeMillis());

final String hms = String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(millis),
                TimeUnit.MILLISECONDS.toMinutes(millis) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)),
                TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)));
System.out.println(hms);