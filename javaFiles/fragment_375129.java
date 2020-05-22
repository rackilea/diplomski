public class Main {
    private static final Logger LOG = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        try {
            Process p = Runtime.getRuntime().exec("myshellscript");
            Thread outHandler = new OutputHandler(p.getInputStream(), "UTF-8");
            outHandler.setDaemon(true);
            outHandler.start();
            Thread errHandler = new OutputHandler(p.getErrorStream(), "UTF-8");
            errHandler.setDaemon(true);
            errHandler.start();
            sendInput(p, "the input data", "UTF-8");
            int result = p.waitFor();
            outHandler.join();
            errHandler.join();
            System.out.println("exit code: " + result);
        } catch (IOException ex) {
            LOG.log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            LOG.log(Level.SEVERE, null, ex);
        }
    }    

private void sendInput(Process process, String input, String encoding)
        throws IOException {

    try (OutputStream stream = process.getOutputStream();
            Writer writer = new OutputStreamWriter(
                    stream, encoding == null ? "UTF-8" : encoding);
            PrintWriter out = new PrintWriter(writer)) {
        if (input != null) {
            Reader reader = new StringReader(input);
            BufferedReader in = new BufferedReader(reader);
            String line = in.readLine();
            while (line != null) {
                out.println(line);
                line = in.readLine();
            }
        }
    }
}

    private static class OutputHandler extends Thread {
        private BufferedReader in;

        private OutputHandler(InputStream in, String encoding)
                throws UnsupportedEncodingException {
            this.in = new BufferedReader(new InputStreamReader(
                    in, encoding == null ? "UTF-8" : encoding));
        }

        @Override
        public void run() {
            try {
                String s = in.readLine();
                while (s != null) {
                    System.out.println(s);
                    s = in.readLine();
                }
            } catch (IOException ex) {
                LOG.log(Level.SEVERE, null, ex);
            } finally {
                try {
                    in.close();
                } catch (IOException ex) {
                    LOG.log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}