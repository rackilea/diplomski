for (int index = 0; index < numDrones; index++) {
    MakeDrone md = new MakeDrone();
    Timer timer = new Timer(30, new Drone(md));
    container.add(md);
    timer.setInitialDelay(0);
    timer.start();
}