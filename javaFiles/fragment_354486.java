for (int i = 0; i < 10; i++) {
    t[i] = new Thread1(d, i);
    t[i].start();
}

for (int i = 0; i < 10; i++) {
    try {
        t[i].join();
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}