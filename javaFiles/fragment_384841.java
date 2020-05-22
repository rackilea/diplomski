telnetHandler = new Handler() {
        @Override
        public void publish(LogRecord record) {
            System.err.println(record.getMessage());
        }

        @Override
        public void flush() {
            System.err.flush();
        }

        @Override
        public void close() throws SecurityException {
            System.err.close();
        }
    };