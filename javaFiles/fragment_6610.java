boolean isSockeStarted = false;



  @Override
  public int onStartCommand(Intent intent, int flags, int startId) {
...


        if (socket == null || !socket.isOpen() || socket.isPaused()) {

            if (isSockeStarted) { //not started
            } else {
                isSockeStarted = true;
            }
        }
....