final ByteArrayOutputStream out = new ByteArrayOutputStream() {
        @Override
        public void close() throws IOException {
            open.remove(path);
            super.close();
        }
    };