long startAt = System.currentTimeMillis();
long pause = 5000;
System.out.println(DateFormat.getTimeInstance().format(new Date()));
while ((startAt + pause) > System.currentTimeMillis()) {
    // Waiting...
}
System.out.println(DateFormat.getTimeInstance().format(new Date()));