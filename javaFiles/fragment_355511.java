while (!goOut) {


            if (dataInputStream.available() > 0) {

                final String incoming = dataInputStream.readUTF();



                MainActivity.this.runOnUiThread(new Runnable() {

                    @Override
                    public void run() {

                        incomingmsg.setText(incoming);
                        mustDecrypt = incomingmsg.getText().toString();



                        if (encrypt)
                            try {
                                mustDecrypt = AESHelper.decrypt(seed, mustDecrypt);
                                msgLog += mustDecrypt;

                            } catch (Exception e){
                                e.printStackTrace();
                            }
                            else msgLog += mustDecrypt;




                        chatMsg.setText(msgLog);
                    }
                });
            }