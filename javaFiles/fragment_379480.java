static volatile boolean running = true;

public static void main(String[] args) throws IOException {
    Path name = Paths.get("delete.me");
    MappedByteBuffer mapped;
    try(FileChannel fc1 = FileChannel.open(name, READ,WRITE,CREATE_NEW,DELETE_ON_CLOSE)) {
        mapped = fc1.map(FileChannel.MapMode.READ_WRITE, 0, 4096);
    }
    Thread thread1 = new Thread(() -> {
        LockSupport.parkNanos(TimeUnit.MILLISECONDS.toNanos(50));
        while(running && !Thread.interrupted()) {
            LockSupport.parkNanos(TimeUnit.MILLISECONDS.toNanos(100));
            byte[] b = new byte[5];
            mapped.position(4000);
            mapped.get(b);
            System.out.println("read "+new String(b, StandardCharsets.US_ASCII));
        }
    });
    thread1.setDaemon(true);
    thread1.start();
    Thread thread2 = new Thread(() -> {
        byte[] b = "HELLO".getBytes(StandardCharsets.US_ASCII);
        while(running && !Thread.interrupted()) {
            LockSupport.parkNanos(TimeUnit.MILLISECONDS.toNanos(100));
            mapped.position(4000);
            mapped.put(b);
            System.out.println("wrote "+new String(b, StandardCharsets.US_ASCII));
            byte b1 = b[0];
            System.arraycopy(b, 1, b, 0, b.length-1);
            b[b.length-1] = b1;
        }
        mapped.force();
    });
    thread2.setDaemon(true);
    thread2.start();
    LockSupport.parkNanos(TimeUnit.SECONDS.toNanos(5));
    thread2.interrupt();
    LockSupport.parkNanos(TimeUnit.SECONDS.toNanos(2));
    running = false;