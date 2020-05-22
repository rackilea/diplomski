public class RecordAttachmentDTO {
    private String id;
    private List<Map<String, String>> attachments = new ArrayList<>();

    public RecordAttachmentDTO(RecordAttachment recordAttachment) {
        this.id = recordAttachment.getId();
        List<Attachment> attachments = recordAttachment.getAttachments();
        attachments.forEach(attachment -> addAttachment(attachment));

    }

    private void addAttachment(Attachment attachment) {
        attachment.getId().forEach(attachmentID -> attachments.add(Collections.singletonMap("id", attachmentID.getAttachmentID())));
        Map<String, String> fileMap = new HashMap<>();
        fileMap.put("filename", attachment.getFilename());
        fileMap.put("fileType", attachment.getFiletype());
        attachments.add(fileMap);
    }

    public List<Map<String, String>> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<Map<String, String>> attachments) {
        this.attachments = attachments;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}