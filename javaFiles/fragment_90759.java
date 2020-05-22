private TextView textView2;

public void test(){

    new Thread(new Runnable() {
        @Override
        public void run() {
            final StringBuilder test = new StringBuilder();
            try{
                Socket s = new Socket(InetAddress.getByName("ipaddress"), 1111);
                test.append(s.isConnected());

                BufferedReader readFromHost = new BufferedReader(new InputStreamReader(s.getInputStream()));
                readFromHost.ready();


                test.append(readFromHost.readLine());
                s.close();
            }catch(Exception e){
                e.printStackTrace();
            }

            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    textView2.setText(test.toString());
                }
            });
        }
    }).start();
}