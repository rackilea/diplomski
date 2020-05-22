while (hellostrack.size() > 8) { // should this be >= 8?
    producerlock.await();
}

// and

while (hellostrack.isEmpty()) {
    consumerlock.await();
}