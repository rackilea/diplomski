...
    synchronized (obj1) {
        System.out.println(1);
        synchronized (obj2) {
            System.out.println(2);
        }
    }
    ...