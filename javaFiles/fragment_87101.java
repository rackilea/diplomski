Calendar now = Calendar.getInstance();
Calendar before = Calendar.getInstance();
before.set(Calendar.HOUR_OF_DAY, 14);
before.set(Calendar.MINUTE, 0);
Calendar after = Calendar.getInstance();
after.set(Calendar.HOUR_OF_DAY, 16);
after.set(Calendar.MINUTE, 0);
System.out.println(now.before(after) && now.after(before));