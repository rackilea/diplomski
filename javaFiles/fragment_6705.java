byte[] inputBytes = IOUtils.toByteArray(inputStream);
PDDocument document = PDDocument.load(new ByteArrayInputStream(inputBytes));

...

document.addSignature(new PDSignature(this.dts.getDocumentTimeStamp()), this);
saveIncremental(new FileOutputStream("C:/result.pdf"),
    new ByteArrayInputStream(inputBytes), document, this);
document.close();