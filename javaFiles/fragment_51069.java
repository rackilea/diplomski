@GetMapping("/attachments")
public ResponseEntity<byte[]> getAttachment() {
    String file = "iVBORw0KG ... 5CYIIA";
    byte[] decoded = Base64.getDecoder().decode(file);

    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);

    ContentDisposition contentDisposition = ContentDisposition.builder("attachment")
        .filename(fileName).build();
    headers.setContentDisposition(contentDisposition);

    return ResponseEntity.ok().headers(headers)
        .contentLength(decoded.length)
        .body(decoded);
}