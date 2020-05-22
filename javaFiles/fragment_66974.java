public int dialer() { 
    // status for debug. If status == 4 then you connected successfully
    int status; 
    // create process of wvdial
    ProcessBuilder builder = new ProcessBuilder("wvdial");

    try {
        // start wvdial
        final Process process = builder.start();

        // wvdial listener thread
        final Thread ioThread = new Thread() {
            @Override
            public void run() {
                try {

                    final BufferedReader reader = new BufferedReader(
                            new InputStreamReader(process.getErrorStream()));
                    // wvdial output line
                    String line;

                    while ((line = reader.readLine()) != null) {
                        // if "local  IP address" line detected set status 1
                        if (line.contains("local  IP address")) {
                            status = 1;
                        }
                        if (line.contains("remote IP address")) {
                            status = 2;
                        }
                        if (line.contains("primary   DNS address")) {
                            status = 3;
                        }
                        if (line.contains("secondary DNS address")) {
                            status = 4;
                        }
                    }

                    reader.close();
                } catch (final Exception e) {
                }
            }
        };
        // start listener
        ioThread.start();
        // wait 6 secs and return status. Some kind of timeout
        Thread.sleep(6000);
    } catch (Exception e) {
    }
    return status;
}