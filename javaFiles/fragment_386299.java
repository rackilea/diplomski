try {
    Process p = Runtime.getRuntime().exec("su");
    DataOutputStream os = new DataOutputStream(p.getOutputStream());
    os.writeBytes("sync; sync\n");
    os.writeBytes("exit\n");
    os.flush();
} catch (Exception e) {
    e.printStackTrace();
}