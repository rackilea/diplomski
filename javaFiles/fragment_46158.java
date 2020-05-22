// code before
    if (connected) {
        try {
            outputStream = socket.getOutputStream(); //gets the output stream of the socket
            performAction();  // call it here
        } catch (IOException e) {
            e.printStackTrace();
        }
    }