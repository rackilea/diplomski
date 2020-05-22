public class ChronicleTest {

private String chroniclePath = "/tmp/chronicle-test";

private int msgCount = 10;

private int i = 0;

    @Test
    public void writeToQ() {
        ChronicleQueue queue = ChronicleQueueBuilder.single(chroniclePath).build();
        ExcerptAppender appender = queue.acquireAppender();
        for (i = 1; i <= msgCount; i++) {
            appender.writeBytes(b -> {
                b.writeInt(i);
            });
        }
        ExcerptTailer tailer = queue.createTailer();
        tailer.toEnd();
        long lastIndex = tailer.index();
        tailer.moveToIndex(lastIndex - 5);

        while (tailer.readBytes(b -> {
            int value = b.readInt();
            System.out.println("Received:" + value);
        }))
            System.out.println("Completed");
    }
}