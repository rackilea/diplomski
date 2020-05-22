private static ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();

    public static void main(String[] args) {
        scheduledExecutorService.scheduleAtFixedRate(() -> {
            try {
                Process process = new ProcessBuilder("ps", "-p", "2782", "-o", "%mem").redirectErrorStream(true).start();
                try(BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
                    String s = reader.lines().collect(Collectors.joining("\n"));
                    System.out.println(s);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }, 0, 2, TimeUnit.SECONDS);
    }