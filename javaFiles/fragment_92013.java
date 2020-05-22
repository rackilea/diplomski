@Override
    public void onClick(DialogInterface dialog, int which) {

      thread = new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                mPrintWriter.println("192.168.2.131;"+mSocket.getLocalAddress().toString().replace("/", "")+";byebye");
            } catch (IOException e) {
                e.printStackTrace();
            } finally{
                mPrintWriter.close();
                mBufferedReader.close();
            }

            try{
                net_.interrupt();
            }catch (IOException e) {
                 e.printStackTrace();
            }finally{
                mSocket.close();
            }
        }
     });

     thread .start();
    }