for (Host host: hosts) {
    executor.submit(()->{
        try {
            connect(host,"message",1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
});