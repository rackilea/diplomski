public ResponseEntity handleFile(@RequestParam MultipartFile file) throws IOException 
{
    InputStream inputStream = file.getInputStream();
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    ZipOutputStream zipOutputStream = new ZipOutputStream(byteArrayOutputStream);
    ZipEntry zipEntry = new ZipEntry(file.getOriginalFilename());
    zipOutputStream.putNextEntry(zipEntry);

    byte[] bytes = new byte[1024];
    int length;
    while((length = inputStream.read(bytes)) >= 0) {
        zipOutputStream.write(bytes, 0, length);
    }
    zipOutputStream.close();

    // Do something with the byteArrayOutputStream
    System.out.println(byteArrayOutputStream.toString());

    return ResponseEntity.accepted().build();
}