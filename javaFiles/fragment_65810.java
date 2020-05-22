public void doStuff() {
    A a = dao.findByWhatever();
    if (a.hasProperty()) {
        B b = restService.doRemoteRequestWithRetries(); // May take long time
    }
    a.setProp(b.getSomethig());
    dao.save(b);
}