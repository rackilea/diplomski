static Task stop = // some special value

public void run() {
  while (true) {
    Task task = taskQueue.take();
    if (task == stop) {
        break;
    }
    task.run();
  }
}