// Open input and output streams

    try {
        clientSocket = echoServer.accept();
        is = new DataInputStream(clientSocket.getInputStream());
        InputStreamReader ir = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(ir);
        os = new PrintStream(clientSocket.getOutputStream());
        out = new BufferedWriter(new FileWriter("C://Users//Vagos//Desktop//file.txt"));
        // As long as we receive data, echo that data back to the client.

        while (true) {
            line = br.readLine();
            System.out.println(line);
            os.println(line);
            os.flush();
            if( line != null ){
             out.write(line + '\n');
             out.flush();
            }
        }
    }