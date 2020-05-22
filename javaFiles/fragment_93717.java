SimpleDateFormat dateFormat = new SimpleDateFormat(
                                "yyyy.MM.dd G 'at' HH:mm:ss z", Locale.UK);
dateFormat.setTimeZone(TimeZone.getTimeZone("GMT+1:00")); //London?

String fullDateUK = dateFormat.format(new Date());

System.out.println(fullDateUK);