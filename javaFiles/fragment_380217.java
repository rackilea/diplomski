public class Stream{
    private Socket socket;
    private OnCloseStreamListener closeListener;
    private OnReadObjectListener readListener;
    private ObjectInputStream in;
    private ObjectOutputStream out;
    private Thread thread;

    public static interface OnReadObjectListener{
        void onReadObject (Object obj);
    }

    public static interface OnCloseStreamListener{
        void onCloseStream ();
    }

    //Used by the receiver to create an input socket
    public Stream (Socket socket){
        this.socket = socket;
        out = new ObjectOutputStream (socket.getOutputStream ());
    }

    //Used by the user to create an output socket, when the client wants to create a socket with the server
    public Stream (String address, int port){
        socket = new Socket (address, port);
        out = new ObjectOutputStream (socket.getOutputStream ());
    }

    public void setOnCloseStreamListener (OnCloseStreamListener listener){
        closeListener = listener;
    }

    public void setOnReadObjectListener (OnReadObjectListener listener){
        readListener = listener;
    }

    public synchronized void startReading (){
        if (thread != null) return;

        thread = new Thread (new Runnable (){
            @Override
            public void run (){
                try{
                    in = new ObjectInputStream (socket.getInputStream ());
                    reading = true;
                    while (reading){
                        Object obj = in.readObject ();
                        if (obj == null){
                            //The other device has closed its socket stream
                            reading = false;
                            closeListener.onCloseSocketStream ();
                        }else{
                            readListener.onReadObject (obj);
                        }
                    }
                }catch (SocketException e){
                    //stopReading() has been called
                }catch (IOException e){
                    //Error handling
                }
            }
        }).start ();
    }

    public synchronized void writeObject (Object obj){
        out.writeObject (obj);
        out.flush;
    }

    public synchronized void close (){
        if (thread != null){
            reading = false;
            socket.close ();
            in.close ();
            out.close ();
            thread = null;
        }else{
            socket.close ();
            in.close ();
        }
    }
}