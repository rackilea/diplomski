CharStreams.toString(CharStreams.newReaderSupplier(new InputSupplier<InputStream>() {
        @Override
        public InputStream getInput() throws IOException {
            return inputStream;
        }
    }, Charsets.UTF_16));