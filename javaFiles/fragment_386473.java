@Override
public void run(){
    try{
        ServerSocket ss = new ServerSocket(port);
        while(true){
            Socket cl = ss.accept();
            new ClientThread(cl).start();
        }
    }catch(Exception e){}
}