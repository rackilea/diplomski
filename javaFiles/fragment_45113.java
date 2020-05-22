try{
    ServerSocket acceptor = new ServerSocket(4782);

    while (true) {
        Socket clientSock = acceptor.accept();  
    }
} catch(IOException e){
    System.err.println("ERROR: Network problem:" + e.getMessage());
}