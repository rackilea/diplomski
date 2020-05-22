Log.d(TAG,"Start server");
            BluetoothServerSocket serverSocket = null;
            try {
                serverSocket = adapter.listenUsingRfcommWithServiceRecord("ime", uuid);
            } catch (Exception e) {
                e.printStackTrace();
            }

            while (true) {
                try {
                    serverSocket.accept();
                } catch (Exception e) {
                    e.printStackTrace();

                }
            }