private class StreamGobbler extends Thread {
    private InputStream in;
    private PrintStream out;

    private StreamGobbler(InputStream in, PrintStream out) {
        this.in = in;
        this.out = out;
    }

    @Override
    public void run() {
        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(in));
            String line = null;
            while ((line = input.readLine()) != null)
                out.println(line);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}