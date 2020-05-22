public static void main(String[] args) {
    final MyClass mc = new MyClass();
    final Object o = new Object();
    mc.addListener(o);
    for (int i = 0; i < 99999; i++) {
        Object o1 = new Object();
        mc.addListener(o1);
    }
    Runnable remove = new Runnable() {

        @Override
        public void run() {
            mc.removeListener(o);
        }
    };

    new Thread(remove).start();
    mc.fireEvent();
}

public static class MyClass {

    protected Set<Object> synchronizedListeners = Collections.synchronizedSet(new LinkedHashSet<Object>());

    public void addListener(Object listener) {
        synchronizedListeners.add(listener);
    }

    public void removeListener(Object listener) {
        System.out.println("remove " + synchronizedListeners.size());
        synchronizedListeners.remove(listener);
        System.out.println("done remove " + synchronizedListeners.size());
    }

    public void fireEvent() {
        System.out.println("fire " + synchronizedListeners.size());
        synchronized (synchronizedListeners) {
            for (Object listener : synchronizedListeners) {
                // do something with listener
            }
        }
        System.out.println("done fire "  + synchronizedListeners.size());
    }
}