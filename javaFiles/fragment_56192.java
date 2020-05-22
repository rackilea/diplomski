private static final String TAG = "Yo! I got an error";

   public static List<Process> getMyInfo() {
        List<Process> myData = new ArrayList<>();
        List<String> stdout = Shell.SH.run("cat /proc/net/xt_qtaguid/stats");
        for (String line : stdout) {
            try {
                myData.add(new Process(line));
            } catch (Exception e) {
                Log.d(TAG, "This line ain't working" + line);
            }
        }
        return muData;
    }