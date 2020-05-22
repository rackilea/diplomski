ScheduledExecutorService executor = new ScheduledThreadPoolExecutor(1);
executor.scheduleAtFixedRate(new Runnable() {
        public void run()
        {
            obj.openFile();
            obj.getFileContents();
            obj.processFileContent();
            obj.closeFile();
            obj.deleteFile();
         }
    }, 0, 1, TimeUnit.MINUTES);