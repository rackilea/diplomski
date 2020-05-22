...
public void putMethod() { ... }
public void iterateMethod() {
    sharedMap.keySet().stream().forEach((s) -> {
        System.out.println("Read key " + s);
    }
}

public static void main(String[] args) throws InterruptedException {
    ...
    t1.start();
    Thread.sleep(20); // sleep time depends on your computer's speed ;-)
    t2.start();
    ...
}
...