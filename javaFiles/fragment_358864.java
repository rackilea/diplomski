System.out.println( "hello" );
    String line;

    Process process = Runtime.getRuntime ().exec ("cmd.exe /c slcanterm.exe");

    InputStream stderr = process.getErrorStream ();
    InputStream stdout = process.getInputStream ();

    BufferedReader reader = new BufferedReader (new InputStreamReader(stdout));
    BufferedReader error = new BufferedReader (new InputStreamReader(stderr));

    new Thread() {
        public void run() {
            try {
                String err;
                while ((err = error.readLine ()) != null)     
                    System.out.println ("[Stderr] " + err);
            } catch (Exception e) {
                e.printStackTrace();
            }

    }}.start();

    while ((line = reader.readLine ()) != null)     
        System.out.println ("[Stdout] " + line);

    System.out.println( "buy" );