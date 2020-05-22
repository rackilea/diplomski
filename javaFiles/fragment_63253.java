private void processClientRequest(Socket clientSocket) throws IOException {
        InputStream in = clientSocket.getInputStream();//wrap this in a object stream or other to read lines/ utf
        int i = 0;
        while(i++ < 1000 && in.available() > 0){
          int read = in.read();//use it if u want, like to a string builder declared out of loop and echo it back after u read input
         }
        PrintWriter out = 
        new PrintWriter(clientSocket.getOutputStream());
        long time = System.currentTimeMillis();

        out.write("Server - " + time + ": " + in);

        out.close();//should be in seperate try catches so if 1 close fails u still close other and finally close socket in 3rd try catch
        in.close();
}