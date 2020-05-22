@ResponseBody
@RequestMapping("/attachment", produces={ /* Types of files */ })
public byte[] getAttachment() {
    Attachment attachment = null; // Retrieve your attachment somehow
    return attachment.getFile();
}