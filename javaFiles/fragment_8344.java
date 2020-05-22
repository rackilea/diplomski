ByteArrayResource fileAsResource = new ByteArrayResource(file.getBytes()) {

        @Override
        public String getFilename() {
            return file.getOriginalFilename();
        }

        @Override
        public long contentLength() throws IOException {
            return file.getSize();
        }
    };