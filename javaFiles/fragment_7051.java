/*
 * This thread is used for reading content which will be written by native code using STDOUT.
 */

new Thread(new Runnable() {

    @Override
    public void run() {
        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader(mOutfile));
            while(in.ready()) {
                final String str = in.readLine();
                mHandler.post(new Runnable() {

                    @Override
                    public void run() {

                        Toast.makeText(RedirectionJni.this, str, Toast.LENGTH_LONG).show();
                    }

                });
            }
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}).start();