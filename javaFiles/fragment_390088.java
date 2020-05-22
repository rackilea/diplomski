class StreamHandler extends Thread {
        private final BufferedReader in;
        private final JTextArea[] textArea;

        public StreamHandler(final BufferedReader in) {
            this.in = in;
        }

        @Override
        public void run() {
            try {
                String line = null;
                while ((line = this.in.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (IOException e) {
                log.info("StreamHandler got interrupted");
                e.printStackTrace();
            }
        }
    }