public static boolean getLockScreenStatus() throws IOException {
    boolean status = false;
    Process process_screen = null;
    BufferedReader buf_screen;
    String str_screen;
    String command = System.getProperty("java.home") + File.separator + "tools" + File.separator + "sdb.exe"
            + " -s " + "0000d04800009200 shell ps aux | grep lockscreen";
    process_screen = Runtime.getRuntime().exec(command);
    buf_screen = new BufferedReader(new InputStreamReader(process_screen.getInputStream()), 1024);

    while ((str_screen = buf_screen.readLine()) != null) {

        if (str_screen.contains("org.tizen.lockscreen/bin/lockscreen")) {
            status = true;
            System.out.println(str_screen);
        }
    }

    return status;
}