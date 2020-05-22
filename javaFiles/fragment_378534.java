Striped<Lock> locks = Striped.lock(stripes);
Lock l = locks.get(string);
l.lock();
try {
  // do stuff 
} finally {
  l.unlock();
}