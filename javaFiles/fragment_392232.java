@Override
    public void run() {
        try {
            BufferedReader ins = new BufferedReader(new InputStreamReader(soc.getInputStream()));

            Runtime r = Runtime.getRuntime();
            Process videoProcess = null;
            Process killProcess = null;
            boolean android = false;

            int i = 0;
            while (i < 1) {
                String request = ins.readLine();

                if (request == null || request.equals("close")) {
                    if (android) {
                        killProcess = r.exec(new String[]{"bash","-c","pkill -9 -f 'gst-launch-1.0'"});
                    }
                    else {
                        killProcess = r.exec(new String[]{"bash","-c","pkill -9 -f 'http-launch'"});
                    }
                    i++;
                }
                else {
                    if (request.equals("android")) {
                        videoProcess = r.exec(new String[]{"bash","-c","sh /home/pi/test-raspicamsrc.sh"});
                        android = true;
                    }
                    else if (request.equals("browser")) {
                        videoProcess = r.exec(new String[]{"bash","-c","sh /home/pi/test-http-launch.sh"});
                        android = false;
                    }
                    else if (request.equals("left")) {
                        serialPort.writeBytes("4".getBytes());//Write data to port
                    }
                    else if (request.equals("right")) {
                        serialPort.writeBytes("6".getBytes());
                    }
                    else if (request.equals("stop")) {
                        serialPort.writeBytes("5".getBytes());
                    }
                    else if (request.equals("forward")) {
                        serialPort.writeBytes("8".getBytes());
                    }
                    else if (request.equals("backward")) {
                        serialPort.writeBytes("2".getBytes());
                    }
                    else {
                        System.out.println("Unknown command");
                    }
                }
            }
            ins.close();
            soc.close();
            // We always stop the car in the end.
            serialPort.writeBytes("5".getBytes());

        }
        catch (IOException e) {
            System.out.println("Error input/output while initializing the server (Port 6020 may already be in use)");
        }
    }