static boolean isClosed;

public void run() {
    InputStream inputStream = null;
    try {
        inputStream = new FileInputStream(file) {
            @Override
            public void close() throws IOException {
                isClosed = true;
                super.close();
            }
        };
        // more stuff here