private void connActionPerformed(java.awt.event.ActionEvent evt) {
        boolean success = false;
        do {
            try {
                if (port.getText().equals("")) {
                    labInfo.setText("Port number cannot be empty!!");
                } else {
                    portnum = Integer.parseInt(port.getText());//here i am getting user's entered port number
                    ServerSocket serverSocket = new ServerSocket(portnum);
                    System.out.println("Connected to Server");
                    mServer = new Server(serverSocket);//Which means you need to implement a constructor with a Server argument.

                    //conn.setEnabled(false);
                    //port.setEditable(false);
                    //abInfo.setText("Waiting for Connection.....");
                    mServer.start();
                    success = true;
                }

            } catch (BindException ex) {
                System.out.println("Port in use");
            }
        } while (success);

    }