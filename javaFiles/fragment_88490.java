new Thread(new Runnable() {
            @Override
            public void run() {
                try
                {
                    Log.i(debugString, "Attempting to connect to server");
                    socket = new Socket(hostname, portnumber);
                    Log.i(debugString, "Connection established");

                    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                    bw.write("Connected");
                    bw.newLine();
                    bw.flush();

                    BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    System.out.println("Message from server:" + br.readLine());


                } catch (IOException e)

                {
                    Log.e(debugString, e.getMessage());
                    //e.printStackTrace();
                }
            }
        }).start();