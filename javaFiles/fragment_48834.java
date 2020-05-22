BlockingQueue<FloorRequest> queue = ...;
while (/* some condition */) {
  FloorRequest request = queue.take();
  switch (request.getDirection()) {
    case UP:
      // do something
      break;
    case DOWN:
      // do something else
      break;
  }
}