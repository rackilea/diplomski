final OutputStream stdOut = System.out;
try {
    System.setOut(new PrintStream(new OutputStream() {
        private PrintStream ps = new PrintStream(new File("output-file.txt"));

        @Override
        public void write(int b) throws IOException {
            ps.write(b);
            stdOut.write(b);
        }

        @Override
        public void flush() throws IOException {
            super.flush();
            ps.flush();
            stdOut.flush();
        }

        @Override
        public void close() throws IOException {
            super.close();
            ps.close();
            // stdOut.close(); // Normally not done
        }
    }));
} catch (Exception e) {
    e.printStackTrace();
}

System.out.println("Hello, world!");