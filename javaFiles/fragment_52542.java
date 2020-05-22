PipedReader reader = new PipedReader();

Runnable feeder = new Runnable() {
    @Override
    public void run() {
        try (PipedWriter writer = new PipedWriter(reader)) {
            linesModifiedAndAppendedFromVariousFiles.forEachOrdered(line -> {
                try {
                    writer.write(line);
                    writer.write('\n');
                } catch (IOException e) {
                    throw new UncheckedIOException(e);
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
};
new Thread(feeder).start();

someLibraryMethod.consumeReader(reader);