try {
    t1.join();
    t2.join();
} catch (Exception e) {
    throw new RuntimeException("Handle it properly.", e);
}