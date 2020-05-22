public void stop(){
 try {
     webSocketClient.stop();
     connection.close();
 } catch (Throwable t) {
     t.printStackTrace();//this not called
 }
}