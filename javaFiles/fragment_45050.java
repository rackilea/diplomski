public class DecryptionWotsit {
    private final BlockingDeque<Byte> queue = new LinkedBlockingDeque<Byte>();
    private final InputStream in;
    private final OutputStream out;
    public DecryptionWotsit(InputStream in, OutputStream out) {
        this.in = in;
        this.out = out;
    }

    public void go() {
        final Runnable decryptionTask = new Runnable() {
            @Override
            public void run() {
                try {
                    byte[] encrypted = new byte[1024];
                    byte[] decrypted = new byte[1024];
                    while (true) {
                        int encryptedBytes = in.read(encrypted);

                        // TODO: decrypt into decrypted, set decryptedBytes
                        int decryptedBytes = 0;

                        for (int i = 0; i < decryptedBytes; i++)
                            queue.addFirst(decrypted[i]);
                    }
                }
                catch (Exception e) {
                    // exception handling left for the reader
                    throw new RuntimeException(e);
                }
            }
        };
        final Runnable playTask = new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        out.write(queue.takeLast());
                    }
                }
                catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        };
        Executors.newSingleThreadExecutor().execute(decryptionTask);
        Executors.newSingleThreadExecutor().execute(playTask);
    }
}