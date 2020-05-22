public Map<Integer, String> getProcesses() {
    final Map<Integer, String> processes = Maps.newHashMap();
    final boolean windows = System.getProperty("os.name").contains("Windows");
    try {
        final Process process = Runtime.getRuntime().exec(windows ? "tasklist /fo csv /nh" : "ps -e");
        try (final BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
            reader.lines().skip(1).forEach(x -> { // the first line is usually just a line to explain the format
                if (windows) {
                    // "name","id","type","priority","memory?"
                    final String[] split = x.replace("\"", "").split(",");
                    processes.put(Integer.valueOf(split[1]), split[0]);
                }
                else {
                    // id tty time command
                    final String[] split = Arrays.stream(x.trim().split(" ")).map(String::trim)
                            .filter(s -> !s.isEmpty()).toArray(String[]::new); // yikes
                    processes.put(Integer.valueOf(split[0]), split[split.length - 1]);
                }
            });
        }
    }
    catch (IOException e) {
        e.printStackTrace();
    }

    return processes;
}