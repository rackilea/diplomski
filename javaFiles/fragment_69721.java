int pillsCount = 0;
while (pillsCount < 2) {
  MyRunnable task = queue.take();
  if (task.isPoisonPill()) {
    ++pillsCount;
  } else {
    executor.submit(task);
  }
}