public class MyServer implements Runnable {

public int serverPort = 8080;
public String serverIp = "http://192.168.1.115";
public Handler handler = new Handler();
public TextView serverStatus;
public ServerSocket serverSocket;
MyServerMethods myServerMethods = new MyServerMethods();

private AndroidServer2 mActivity;

MyServer(AndroidServer2 activity) {
    mActivity = activity;
}

@Override
public void run() {
    try{
      ServerSocket parent = new ServerSocket(); //create a new socket
      parent.setReuseAddress(true);
      parent.bind(new InetSocketAddress(serverPort)); //bind the server port and reuse it if necessary
        if ( serverIp != null){
            Log.i("Status","READY");
            while (true){
                Socket client = parent.accept(); //accept the incoming connection

                // Client connected now set the button visibilty
                mActivity.runOnUiThread(new Runnable() {

                    @Override
                    public void run() {
                        mActivity.setButtonVisible();
                    }
                });

                try{
                    String path = myServerMethods.readRequest(parent, client);
                    Log.i("PATH",""+path);
                    if (path.contains("FitListXml")){
                        myServerMethods.sendXmlFile(client);
                    } else {
                        myServerMethods.sendPhotoFile(client, path);
                    }

                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        } else{
            Log.i("Error","Internet connection not present");
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}