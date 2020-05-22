try {
                    BluetoothSocket socket = device.createInsecureRfcommSocketToServiceRecord(uuid);
                    socket.connect();
                    Log.v("connect", "connect"); //this,
                }
                catch (IOException e) {
                    e.printStackTrace(); //this
                    Log.v("exception","e"); //and this
                }