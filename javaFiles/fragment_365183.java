public void onTaskRemoved(Intent rootIntent) {
    System.out.println("Service onTaskRemoved.");
    try {
        PrintWriter out = new PrintWriter(socket.getOutputStream());
        out.print("RECONNECT\0");
        out.flush();
        out = null;
    }catch(Exception e) {
        System.out.println("Exception in closing connection.");
        e.printStackTrace();
    }
}