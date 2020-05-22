while (true) {
  try {
    lock.acquire();
    counter++;
  } finally {
    lock.release();
  }
}