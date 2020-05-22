public class QueueManager<T extends MessageType> {

    private Map<UUID, BlockingQueue<T>> queueMap;

    public void removeQueue(UUID id) {
      queueMap.remove(id);
    }

    public BlockingQueue<T> getQueue(UUID id, Supplier<BlockingQueue<T>> createQueue) {
        return queueMap.computeIfAbsent(id, k -> createQueue.get());
    }

    // let's add a default while we're at it 
    public BlockingQueue<T> getQueue(UUID id) {
        return getQueue(id, () -> new ArrayBlockingQueue<T>(50));
    }
}