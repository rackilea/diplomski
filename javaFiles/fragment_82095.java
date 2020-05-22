long seconds = TimeUnit.MILLISECONDS.toSeconds(diff);
System.out.println(seconds);
long minutes=TimeUnit.MILLISECONDS.toMinutes(diff);
System.out.println(minutes);
long hours=TimeUnit.MILLISECONDS.toHours(diff);
System.out.println(hours);
long days=TimeUnit.MILLISECONDS.toDays(diff);
System.out.println(days);