try {
        Process p = Runtime.getRuntime().exec("xterm");
        Thread.sleep(1500);

    } catch (IOException e1 ) {
        e1.printStackTrace();
    }