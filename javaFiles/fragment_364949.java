Lock l = new Lock();
l.lock();  // Call the lock before calling try.
try {
    // Do some processing.
    // All code must go in here including break, return etc.
    return something;
} finally {
    l.unlock();
}