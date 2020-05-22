try {
            server = new ServerSocket(port);
            server.setSoTimeout(10 * 1000);
            socket = server.accept();
            JSFUtils.addFacesInformationMessage("Scan Completed Successfully");
            // takes input from the client socket
            in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            String line = in.readUTF();
        } catch (Exception i) {
            if (i instanceof SocketTimeoutException)
                JSFUtils.addFacesErrorMessage("Scan Timeout, Please click Scan again!");
            else
                i.printStackTrace();
        }