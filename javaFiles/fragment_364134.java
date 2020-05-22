try {
lock.lock();
// work ..
} finally {
lock.unlock();
}