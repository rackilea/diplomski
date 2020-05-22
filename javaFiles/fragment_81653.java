public Timer fillTimer(List<Date> firingTimes) {
    Timer timer = new Timer();
    for (Date whenToFire: firingTimes) {
        timer.schedule(new EventFirer(new MyEvent()), whenToFire);
    }
    return timer;
}