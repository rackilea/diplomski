System.out.println("Waiting for blue hydra client output in json");
            //creating socket and waiting for client connection
            Socket socket = server.accept();
            //read from socket to ObjectInputStream object
        BufferedReader socketReader = 
        new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String message = socketReader.readLine();

            //ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            //convert ObjectInputStream object to String
            //String message = (String) ois.readObject();
            System.out.println("Parsing the Json message received from blue hydra server port 8244: " + message);