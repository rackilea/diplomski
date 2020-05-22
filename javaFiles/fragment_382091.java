Calendar watchFor = Calendar.getInstance();
watchFor.setTime(timeAt);
watchFor.set(Calendar.MILLISECOND, 0);
watchFor.set(Calendar.SECOND, 0);

Calendar now = Calendar.getInstance();
now.setTime(new Date());
now.set(Calendar.MILLISECOND, 0);
now.set(Calendar.SECOND, 0);

if (watchFor.equals(now)) {
    System.out.println("Go for it...");
}