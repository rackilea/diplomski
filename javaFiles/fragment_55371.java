ServerSocket serverSocket = null;
        Socket socket = null;
        try {
            serverSocket = new ServerSocket(Integer.parseInt(port));
            serverSocket.setReceiveBufferSize(2048);
            serverSocket.setSoTimeout(0);
            serverSocket.setReuseAddress(true);
            socket = serverSocket.accept();
        } catch (NumberFormatException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        //do something here in a loop

        try {
            socket.close();
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }