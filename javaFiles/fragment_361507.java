public void sleep() {
    System.out.println("Dein Superheld " + name + " legt sich schlafen.");
    System.out.println(name + " hat wieder volle HP, wenn er/sie wach ist.");
    readyToFight = false;
    Timer timer = new Timer();
    TimerTask task = new TimerTask() {
         public void run() {
              setHealthPointsCurrent(getHealthPointsMax());
              readyToFight = true;
              timer.cancel();
         }
    };

    long delay = 120000L; // 2 minutes delay
    timer.schedule(task, delay);
}