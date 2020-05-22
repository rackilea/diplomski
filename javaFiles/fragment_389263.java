Socket clientSocket =server.accept();
        String returMessage ="Hello from Server ";
        if (clientSocket.getRemoteSocketAddress().toString().equals("192.168.1.3")){ 
            returMessage=returMessage +" welcome browser"; 
        }
        else if(clientSocket.getRemoteSocketAddress().toString().equals("192.168.1.4")){ 
            returMessage=returMessage +" welcome tablet"; 
        }

        OutputStream os = clientSocket .getOutputStream();
        OutputStreamWriter osw = new OutputStreamWriter(os);
        BufferedWriter bw = new BufferedWriter(osw);
        bw.write(returMessage);
        System.out.println("Message sent to the client is "+returMessage);
        bw.flush();