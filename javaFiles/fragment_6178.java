public static void main(String[] args) {
    try {
        Process p = Runtime.getRuntime().exec("/bin/ls");
        final InputStream is = p.getInputStream();
        Thread t = new Thread(new Runnable() {
            public void run() {
                InputStreamReader isr = new InputStreamReader(is);
                int ch;
                try {
                    while ((ch = isr.read()) != -1) {
                        System.out.print((char) ch);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();
        p.waitFor();
        t.join();
        System.out.println("Child Complete");
    } catch (Exception e) {
        e.printStackTrace();
    }
}