public static void main(String[] args) throws IOException {
        AtomicLong idx = new AtomicLong(0);
        try (
            OutputStream out = new OutputStreamMultiVolume(10, () -> new FileOutputStream(getNextFilename(idx)));
            ) {

            out.write("01234567890123456789012345678901234567890123456789".getBytes("UTF-8"));
        }
    }

    private static File getNextFilename(AtomicLong idx) {
        return new File("sample.file." + idx.incrementAndGet() + ".txt");
    }