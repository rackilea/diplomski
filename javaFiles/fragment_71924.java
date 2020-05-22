Calendar cal = Calendar.getInstance();

String str = String
        .format("%02d:%02d:%02d",
                TimeUnit.MILLISECONDS.toHours((cal.getTimeInMillis() - 300000)),
                TimeUnit.MILLISECONDS.toMinutes(cal.getTimeInMillis() - 300000)
                        - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS
                                .toHours(cal.getTimeInMillis() - 300000)),
                TimeUnit.MILLISECONDS.toSeconds(cal.getTimeInMillis() - 300000)
                        - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS
                                .toMinutes(cal.getTimeInMillis() - 300000)));

System.out.println(str);