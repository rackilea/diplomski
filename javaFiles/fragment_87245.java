public void stop(){
 try {
     webSocketClient.stop();
 } catch (Throwable t) {
     t.printStackTrace();//this not called
 }
}