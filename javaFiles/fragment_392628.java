public abstract class ResourcePool<Resource> {
    private final BlockingQueue<Resource> free;

    protected ResourcePool(int freeLimit) {
        free = new ArrayBlockingQueue<>(freeLimit);
    }

    public Resource acquire() {
        Resource resource = free.poll();
        return resource == null ? create() : resource;
    }

    public void recycle(Resource resource) {
        if (!free.offer(resource))
            close(resource);
    }

    protected abstract Resource create();

    protected abstract void close(Resource resource);
}