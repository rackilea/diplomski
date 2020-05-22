public class AttachmentService {

    private final ExecutorService executor = Executors.newSingleThreadExecutor();

    public CreationReceipt<Attachment> createNew(Attachment attachment) {
        String location = computeLocationFor(attachment);
        Future<Attachment> savedAttachment = saveAsynchronously(attachment);
        return new CreationReceipt<>(location, savedAttachment);
    }

    private Future<Attachment> saveAsynchronously(Attachment attachment) {
        return executor.submit(() -> save(attachment));
    }

    private Attachment save(Attachment attachment) { ... }

    private String computeLocationFor(Attachment attachment) { ... }
}