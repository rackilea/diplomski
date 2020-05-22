private static boolean processIsRunning(String processName) throws IOException {

    String taskList = System.getenv("windir") + "\\system32\\tasklist.exe";
    InputStream is = Runtime.getRuntime().exec(taskList).getInputStream();

    try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
        return br
            .lines()
            .anyMatch(line -> line.contains(processName));
    }

}