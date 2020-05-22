final Thread inThread = new Thread() {
            @Override
            public void run() {
                // Use a Scanner to read from the remote server

                Scanner in = null;
                try {
                    in = new Scanner(socket.getInputStream());
                    String line = in.nextLine();
                    while (!isFinished.get()) {
                        System.out.println(line);
                        line = in.nextLine();
                    }
                } catch (Exception e) {
//                  e.printStackTrace();
                } finally {
                    if (in != null) {
                        in.close();
                    }
                }
            };
        };
        inThread.start();