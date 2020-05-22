int read = socket.read(socketbuffer); //after here
if(read == -1){
    socket.close();
}else{ //the logic is weird after this so I just changed it
    socketbuffer.flip();
    System.out.print(new String(socketbuffer.array(), socketbuffer.position(), socketbuffer.limit()));
    socket.write(socketbuffer);
    socketbuffer.clear();

}