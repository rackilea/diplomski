class SendDataToServer extends AsyncTask<Void,Void,Void> {
private Socket socket;
private String name;
private String password;
private static final String debug = "debug";
private static final String info = "INFO";
protected static String server_IP = "192.168.0.101";
protected static final int server_Port = 8607;

@Override
protected void onPreExecute() {
   Thread thread = new Thread(new Runnable() {
       @Override
       public void run() {
           try {

               Log.i(debug,"Attempt to connect to server");

               socket = new Socket(server_IP,server_Port);
               Log.i(debug,"Connection established");

           }catch (IOException e){
               e.printStackTrace();
           }

       }
   });
    thread.start();
    }

@Override
protected Void doInBackground(String... data) {

    JSONObject user = new JSONObject();
    try {
        user.put("name", data[0]);
        user.put("name", data[1]);

    } catch (JSONException e) {
        e.printStackTrace();
    }
    try{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bw.write(String.valueOf(user));
        bw.newLine();
        bw.newLine();
        bw.flush();
        Log.i(info,"JSON has sent");


        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        br.readLine();
        Log.i(info,br.readLine());

    }catch (IOException e) {
        Log.e(debug,"Failed");
    }


    return null;
}

@Override
protected void onPostExecute(Void aVoid) {
    try {
        if(socket!=null){
            socket.close();
        }
    } catch (IOException e) {
        Log.e(debug,"Failed");
    }
 }
}