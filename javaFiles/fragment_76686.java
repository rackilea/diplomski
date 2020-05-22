private class ClientThread implements Runnable {    
   private static final int SERVER_PORT = 6000;
         private static final String SERVER_IP = "109.115.84.90";
            private static final String TAG = "ClientThread";
        private Socket socket;

    public ClientThread(){
                try {
                    InetAddress serverAddress = InetAddress.getByName(SERVER_IP);
                    Log.d(TAG, "creato");
                    socket = new Socket(serverAddress, SERVER_PORT);
                } catch (UnknownHostException e) {
                    Log.e(TAG, "Errore: " + e);
                } catch (IOException e) {
                    Log.e(TAG, "Errore: " + e);
                }
            }

    }

            @Override
            public void run() {
    }
            private void inviaStringa(View view, String ordine) {

            try{
                OutputStream s = socket.getOutputStream();
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(s);
                BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
                PrintWriter out = new PrintWriter(bufferedWriter, true);
                out.println(ordine);
            } catch (Exception e) {
                Log.e(TAG, "Errore: " + e);
            }
        }

        }