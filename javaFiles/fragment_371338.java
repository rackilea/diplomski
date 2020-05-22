tasks.add(new Callable<String>() {
        public String call() throws Exception {
            doSomething(client, surv);
            return surv.getId();
        }
    });