Date date = ...;
DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss",
                                         Locale.US);
format.setTimeZone(TimeZone.getTimeZone("Etc/UTC"));

String result = format.format(date);