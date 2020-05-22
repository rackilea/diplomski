if (serviceRunning) {
  serviceRunning = false;
  stopService(...);
} else {
  serviceRunning = true;
  startService(...);
}