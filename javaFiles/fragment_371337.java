tasks.add(new Callable<String>() {
        public String call() throws Exception {
            client.updateStats(surv).toString();
            return surv.getId();
        }
    });