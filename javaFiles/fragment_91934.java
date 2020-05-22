public static String serializeRecordAttachment(RecordAttachment recordAttachment) throws JsonProcessingException {
    ObjectMapper objectMapper = new ObjectMapper();
    ObjectNode recordNode = objectMapper.createObjectNode();
    recordNode.put("id", recordAttachment.getId());
    List<Attachment> attachments = recordAttachment.getAttachments();
    recordNode.set("attachments", 
    createAttachmentNode(objectMapper,attachments));
    return objectMapper.writeValueAsString(recordNode.toString);
}

private static ArrayNode createAttachmentNode(ObjectMapper objectMapper, List<Attachment> attachments) {
    ArrayNode attachmentsNode = objectMapper.createArrayNode();
    attachments.forEach(attachment -> addAttachment(objectMapper, attachmentsNode, attachment);
    return attachmentsNode;
}

private static void addAttachment(ObjectMapper objectMapper, ArrayNode attachmentsNode, Attachment attachment) {
    attachment.getId().forEach(idField -> {
        ObjectNode attchIdNode = objectMapper.createObjectNode();
        attchIdNode.put("id", idField.getAttachmentID());
        attachmentsNode.add(attchIdNode);
    });
    ObjectNode fileNode = objectMapper.createObjectNode();
    fileNode.put("filename", attachment.getFilename());
    fileNode.put("filetype", attachment.getFiletype());
    attachmentsNode.add(fileNode);
}