public void a(GlobalL globalL) {
    AtomicInteger number = new AtomicInteger(0);
    Work work = () -> {
        return number.incrementAndGet();
    };
    globalL.setWork(work);
}