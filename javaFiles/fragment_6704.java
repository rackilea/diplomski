PDDocument document = PDDocument.load(inputStream);

...

document.addSignature(new PDSignature(this.dts.getDocumentTimeStamp()), this);
document.saveIncremental(new FileOutputStream("C:/result.pdf"));
document.close();