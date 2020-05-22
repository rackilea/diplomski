public class SimpleClientResourcePool implements ResourcePool<Client> {
    private final Queue<Client> pool = new ConcurrentLinkedQueue<>();

    @Override
    public Optional get() {
        return Optional.ofNullable(pool.poll());
    }

    @Override
    public void release(Client value) {
        pool.offer(value);
    }
}