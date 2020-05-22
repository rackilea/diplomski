public class Worker implements Handler.Callback {

    protected Socket socket;
    protected BufferedWriter writer;

    public Worker() throws Exception{    
        this.socket = new Socket("192.168.1.7", 5069);
        this.writer = new BufferedWriter(new OutputStreamWriter(this.socket.getOutputStream(), "utf-8"));
    }

    public BufferedWriter getWriter(){
        return this.writer;
    }

    public Socket getSocket(){
        return this.socket;
    }

    @Override
    public void handleMessage(Message msg) {
        Draw draw = (Draw) msg.obj;
        if (draw != null){          
            if (getWriter() != null){
                try{
                    getWriter().write(DrawUtil.toJson(draw)+"\n");
                    getWriter().flush();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
}