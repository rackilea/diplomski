import android.os.AsyncTask;

public class ConnectToServer extends AsyncTask {
    static Socket socket;
    String encodedBase64;
    int protocolId;
    private static DataOutputStream DOS;

    String value;

    public ConnectToServer(String encoded) {
        this.encodedBase64 = encoded;
    }

    public ConnectToServer(int i) {
        this.protocolId = i;
    }

    public ConnectToServer() {

    }

    protected String doInBackground(Void... arg0) {
        //*****local variable
        String res = null;

        try {
            socket = new Socket("192.168.1.104", 17110);
            DOS = new DataOutputStream(socket.getOutputStream());

            if (protocolId == 1) {
                DOS.writeUTF("pictureload");
                protocolId = 0;
            } else {
                DOS.writeBytes(encodedBase64);

                //*****lets get the string returned by receive() method
                res = receive();
            }

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //*****and return it
        return res;
    }

    public String receive() {
        String receiveResult = null;

        if (socket.isConnected()) {

            try {
                BufferedReader input = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

                StringBuffer line = new StringBuffer();

                while ((receiveResult = input.readLine()) != null) {
                    line.append(receiveResult);
                }

                input.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //***** return your accumulated StringBuffer as string, not current line
        return line.toString();
    }

    protected void onPostExecute(String result1) {
        TimelineActivity tA = new TimelineActivity();
        tA.encodeBase64(result1);
    }
}