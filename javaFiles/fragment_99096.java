//BEWARE: do not "optimize" this method by using buffered streams,
// because COSStandardOutputStream only allows seeking
// if a FileOutputStream is passed, see PDFBOX-4312.
FileInputStream fis = new FileInputStream(fileName);
byte[] ba = IOUtils.toByteArray(fis);
fis.close();
FileOutputStream fos = new FileOutputStream(fileName);
fos.write(ba);
fis = new FileInputStream(fileName);
saveIncremental(fis, fos);