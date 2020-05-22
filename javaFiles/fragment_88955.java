Socket socket = null;
boolean reaching = false;
try {
    socket = new Socket("yourserver.com", 22);
    reaching = true;
}catch(Exception e){
    reaching = false;
}finally{
    if(socket != null){
        try { 
            socket.close();
        }catch(IOException e){}
    }
}

System.out.println(reaching);