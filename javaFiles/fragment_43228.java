Queue<Resource> resources = new ConcurrentLinkedQueue<>();
resources.add(new XResource());
resources.add(new YResource());
resources.add(new ZResource());

ExecutorService service = Executors.newFixedThreadPool(resources.size());
ThreadLocal<Resource> resourceToUse = ThreadLocal.withInitial(() -> resources.remove());

for (int i = 1; i < 9; i++) {
    service.execute(() -> {
        Task task = new Task();
        resourceToUse.setTask(task);
    });
}