public class Example {

    public static void sleep() {
        try { Thread.sleep(400); } catch (InterruptedException e) {};
    }

    public static void main(String[] args) {
        final Example example = new Example(1);
        ExecutorService executor = newFixedThreadPool(2);
        try {
            Future<?> reader = executor.submit(new Runnable() { @Override public void run() {
                int value; do {
                    value = example.getSingleElement();
                    System.out.println("single value is: " + value);
                } while (value != 10);
            }});
            Future<?> writer = executor.submit(new Runnable() { @Override public void run() {
                for (int value = 2; value < 10; value++) example.failDoingAtomic(value);
            }});
            reader.get(); writer.get();
        } catch (Exception e) { e.getCause().printStackTrace();
        } finally { executor.shutdown(); }
    }

    private final Set<Integer> singleElementSet;

    public Example(int singleIntValue) {
        singleElementSet = new HashSet<>(Arrays.asList(singleIntValue));
    }

    public synchronized void failDoingAtomic(int replacement) {
        singleElementSet.clear();
        if (new Random().nextBoolean()) sleep();
        else throw new RuntimeException("I failed badly before adding the new value :-(");
        singleElementSet.add(replacement);
    }

    public int getSingleElement() {
        return singleElementSet.iterator().next();
    }
}