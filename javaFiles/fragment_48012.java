Socket socket = tcp.server.accept();
        System.out.println("A client has connected");
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        out.write("Welcome on the server... type the commands you like, type END to close me\n");
        out.flush();

        try {
            while(!(cmd = in.readLine()).equals("END")) {
                System.out.println("Recieved: " + cmd);

                Process p = Runtime.getRuntime().exec(cmd);
                BufferedReader pRead = new BufferedReader(new InputStreamReader(p.getInputStream()));

                String line;
                while ((line = pRead.readLine()) != null) {
                    System.out.println(line);
                    out.write(line + "\n");
                    out.flush();
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            System.out.println("Shutting down server...");
            socket.close();
            in.close();
            out.close();
        }