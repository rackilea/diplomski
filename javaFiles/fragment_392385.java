private void killChromedriver() throws IOException, InterruptedException {
        String command = "pgrep chromedriver";
        Process process = Runtime.getRuntime().exec(command);
        BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
        List<String> processIds = getProcessedIds (process, br);
        for (String pid: processIds) {
                Process p = Runtime.getRuntime().exec("kill -9 " + pid);
                p.waitFor();
                p.destroy();
        }
    }
    private List<String> getProcessedIds(Process process, BufferedReader br) throws IOException, InterruptedException {
        process.waitFor();

        List<String> result = new ArrayList<>();
        String processId ;

        while (null != (processId = br.readLine())) {
            result.add(processId);
        }

        process.destroy();
        return result;
    }