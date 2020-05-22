protected void onStart() {
        super.onStart();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    client = new Socket(ip,Integer.valueOf(port) );
                    client.setKeepAlive(true);

                   dataInputStream = new DataInputStream(client.getInputStream());
                  //  readdata=readdata+" "+dataInputStream.readUTF();

                    readdata=dataInputStream.readUTF();
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
        }).start();
    }