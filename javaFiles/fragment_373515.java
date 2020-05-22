public class MyClass {
    private TreetSet<Integer> resources = new TreeSet<>();

    public synchronized Integer getAndRemoveResourceOrWait(
            Integer resource) throws InterruptedException {
        while (true) {
            Integer found = resources.tailSet(resource, true).pollFirst();
            if (found != null) {
                return found;
            }
            wait();
        }
    }

    public synchronized void addResource(Integer resource) {
        resources.add(resource);
        notifyAll();
    }
}