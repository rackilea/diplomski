public void run() {
  if (checkNull()) {
    return;
  }

  int localCounter = loadPerInterval - 1;
  int start = 0;
  while (start + localCounter < width * height) {
    localCounter++;
    if (localCounter == loadPerInterval) {
      start = syncCounterUp();
      localCounter = 0;
    }
    if (start + localCounter < width * height) { 
      filterPixel(start + localCounter);
    }
  }
}