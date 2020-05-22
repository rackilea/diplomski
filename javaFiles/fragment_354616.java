@GetMapping("/message/save")
@CrossOrigin(origins = "*")
public void download(@RequestParam("id") Long id, HttpServletRequest request,
                     HttpServletResponse response) throws Exception {
    MessageEntity messageEntity = messageRepository.findById(id).orElseThrow(() -> new Exception("Not found!"));
    String xml = new ObjectMapper().writeValueAsString(messageEntity);
    String fileName = "message.zip";
    String xml_name = "message.xml";
    byte[] data = xml.getBytes();
    byte[] bytes;
    try (ByteOutputStream fout = new ByteOutputStream();
         ZipOutputStream zout = new ZipOutputStream(fout)) {
        zout.setLevel(1);
        ZipEntry ze = new ZipEntry(xml_name);
        ze.setSize(data.length);
        zout.putNextEntry(ze);
        zout.write(data);
        zout.closeEntry();
        bytes = fout.getBytes();
    }
    response.setContentType("application/zip");
    response.setContentLength(bytes.length);
    response.setHeader("Content-Disposition",
            "attachment; "
                    + String.format("filename*=" + StandardCharsets.UTF_8.name() + "''%s", fileName));
    ServletOutputStream outputStream = response.getOutputStream();
    FileCopyUtils.copy(bytes, outputStream);
    outputStream.close();
}