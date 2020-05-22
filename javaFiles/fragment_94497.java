new Thread(new Runnable() {

                @Override
                public void run() {
                    // TODO Auto-generated method stub
                    try {
                        while (true) {
                            client = server_socket.accept();
                            Log.v("test","accepted");
                            IncomingMessage incomingMessage=new IncomingMessage(client);
                            incomingMessage.processMessage();
                        }

                    } catch (Exception e) {
                        // TODO: handle exception
                        Log.v("Exception", "", e);
                    }
                }
            }).start();