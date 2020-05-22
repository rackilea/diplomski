PrintWriter w = new PrintWriter(System.out) {
        @Override
        public void close() {
            flush();
        }
    };