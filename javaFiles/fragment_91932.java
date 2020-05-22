public class AttachmentSerializer extends StdSerializer<Attachment> {

    public AttachmentSerializer() {
        this(null);
    }

    public AttachmentSerializer(Class<Attachment> t) {
        super(t);
    }

    @Override
    public void serialize(
            Attachment attachment, JsonGenerator jgen, SerializerProvider provider)
            throws IOException, JsonProcessingException {

        jgen.writeStartObject();
        jgen.writeArrayFieldStart("attachments");
        for (AttachmentID attachmentID : attachment.getId()) {
            jgen.writeStartObject();
            jgen.writeStringField("id", attachmentID.getAttachmentID());
            jgen.writeEndObject();
        }
        jgen.writeStartObject();
        jgen.writeStringField("filename", attachment.getFilename());
        jgen.writeStringField("filetype", attachment.getFiletype());

        jgen.writeEndObject();
        jgen.writeEndArray();
        jgen.writeEndObject();
    }
}