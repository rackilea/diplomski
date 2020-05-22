Calendar c = Calendar.getInstance();
long now = c.getTimeInMillis();
c.set(Calendar.HOUR_OF_DAY, 0);
c.set(Calendar.MINUTE, 0);
c.set(Calendar.SECOND, 0);
c.set(Calendar.MILLISECOND, 0);
long passed = now - c.getTimeInMillis();
long secondsPassed = passed / 1000;