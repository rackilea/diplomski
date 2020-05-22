network(String host, int port, String data, TextView status, Handler handler)
{
    this.status = false;
    this.txt = status;
    this.handler = handler;
    this.host = host;
    this.port = port;
    this.data = data;
    count = 0;
    //while(!status)
    r = new Runnable(){

        @Override
        public void run() {
            //Log.d("Response", responseLine);
            txt.setText("Connecting...");
            String result = statusShow();
            txt.setText(result);
        }

    };
    this.handler.post(r);

}
@SuppressWarnings({ "deprecation" })
public void statusShow()
{
    try 
    {
        client = new Socket(host, port);
        os = new DataOutputStream(client.getOutputStream());
        is = new DataInputStream(client.getInputStream());
        if(client != null && os != null && is != null)
        {
            os.writeBytes(data);
            while((responseLine = is.readLine()) != null)
            {
                lastMsg = responseLine;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                Log.d("Response", responseLine);
            }
            os.close();
            is.close();
            client.close();
            Log.d("Response", lastMsg);

            return lastMsg;
        }
    } 
    catch (UnknownHostException e)
    {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (IOException e) 
    {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    return "Error";
}