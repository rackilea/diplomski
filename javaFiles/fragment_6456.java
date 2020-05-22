public class Foo implements Runnable{
    private final Selector selector;
    private volatile boolean run;

    public Foo() throws IOException{
        selector = Selector.open();
        run = true;
    }

    public void registerChannel(SocketChannel channel) throws IOException{
        channel.configureBlocking(false);
        // Optionally use a selection key for write as well
        channel.register(selector, SelectionKey.OP_READ);
    }

    public void shutdown(){
        run = false;
        selector.wakeup();
        try{
            selector.close();
        }catch(IOException ignore){}
    }

    public void run(){
        while(run){
            try{
                int readyCount = selector.select();

                // Selector was interrupted or manually woken up
                if(readyCount == 0){
                    // handle appropriately
                }else{
                    Iterator<SelectionKey> iterKeys = selector.selectedKeys().iterator();

                    while(iterKeys.hasNext()){
                        SelectionKey key = iterKeys.next();

                        if(key.isReadable()){
                            SocketChannel chn = (SocketChannel) key.channel();

                            // Process input here
                        }else{
                            // We aren't interested in non-readable channels atm
                        }

                        // Very important
                        iterKeys.remove();
                    }
                }
            }catch(IOException ex) {
                // handle selector exception
            }
        }
    }
}