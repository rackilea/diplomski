String path = /assets/BookPDFs;

private void uploadFile(Book book, MultipartFile file) throws java.io.IOException {
String destinationDirectory = path + File.separator;
String fileName = SecurityUtil.getSimpleAlphaNum(file.getOriginalFilename());
File destination = new File(destinationDirectory + fileName);
FileUtils.copyInputStreamToFile(file.getInputStream(), destination);
book.setName(fileName);
BookBA.saveOrUpdate(book);