CronTrigger cal = new CronTrigger("Test", "Test", "0 0/10 * * * ?" );
...
end = start + 1000000;
...
while (current < end) {
  if (i > 0) {
  System.out.println(i + ":" + current);
  }
  Date next = cal.getFireTimeAfter(new Date(current));
  current = next.getTime();
  i++;
}