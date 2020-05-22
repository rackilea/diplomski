for (WeakReference<Subscriber> subRef : subscribers) {
    Subscriber sub = subRef.get();
    if (sub != null) {
        sub.update();
    }
}