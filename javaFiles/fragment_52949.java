public class AttachmentService {

    public CreationReceipt<Attachment> createNew(Attachment attachment) {
        String location = computeLocationFor(attachment);
        Future<Attachment> savedAttachment = saveAsynchronously(attachment);
        return new CreationReceipt<>(location, savedAttachment);
    }

    private Future<Attachment> saveAsynchronously(Attachment attachment) { ... }

    private String computeLocationFor(Attachment attachment) { ... }
}