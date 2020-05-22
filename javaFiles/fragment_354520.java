public void scheduleFileTask() {
    final FileHandler fh = new FileHandler("app.log"),true);
    Runtime.getRuntime().addShutdownHook(new Thread() {
        @Override
        public void run() {
            fh.close();
        }
    });
    timer.schedule(new MyRoutine(fh), 1000, 60000);
}