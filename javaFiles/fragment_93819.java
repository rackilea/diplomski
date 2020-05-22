public static void runCmd(String cmd) {
    DataOutputStream os;
    try {
        Process process = Runtime.getRuntime().exec("su");
        os = new DataOutputStream(process.getOutputStream());
        os.writeBytes(cmd + "\n");
        os.writeBytes("exit\n");
        os.flush();
        os.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
}