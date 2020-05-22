tasks.add(new Callable<String>() {
        public String call() throws Exception {
            updater.performUpdate(client, surv);
            return surv.getId();
        }
    });