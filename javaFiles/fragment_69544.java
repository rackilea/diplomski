executor.submit(()->{
     for (Host host:hosts) {
        try {
            connect(host,"message",1);
            } catch (Exception e) {
            e.printStackTrace();
        }
    }
});