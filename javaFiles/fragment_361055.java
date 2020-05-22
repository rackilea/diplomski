SocketImpl socket = new SocketImpl();
socket.setObserver(new SocketObserver() {
      @Override
      public void MessageReceived(Object message) {
              //Message received do something with it
      }
});

socket.start();