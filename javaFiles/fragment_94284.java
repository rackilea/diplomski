private class UPPainter implements Runnable {  
    @Override  
    public void run() {  
        while(true) {  
            ReceivedMsg msg = queue.take();  
            for(final IPacketListener c : listeners) {  
                new Thread(new ListenerUp(c, msg)).start();  
            }  
        }  
    }  
}