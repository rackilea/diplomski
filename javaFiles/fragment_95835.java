while (!shouldIStop()/*some condition in case if you ever want to stop*/) {
        Socket socket = new Socket();
        try {
            socket.connect(yourAddress, 1000);
            //do something...
        } catch (IOException e) {

        } finally {

        }
    }