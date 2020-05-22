class ConnAsyncTask extends AsyncTask<Void, Integer, String> {
    protected String doInBackground(Void... arg0) {

        try {
            Socket socket = new Socket("192.168.1.94",60);
            DataOutputStream DOS = new 
            DataOutputStream(socket.getOutputStream());
            DOS.writeUTF("HELLO_WORLD");
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}