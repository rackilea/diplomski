Calendar cal = Calendar.getInstance();
cal.setTime(new Date());
long now = cal.getTimeInMillis();
cal.add(Calendar.DAY_OF_YEAR, 1);

long then = cal.getTimeInMillis();
long secondsFromEpoch = (then - now) / 1000;

System.out.println(secondsFromEpoch);