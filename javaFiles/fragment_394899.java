// Assuming you provide the following yourself:
  File inputFile; 
  File outputFile;
  String userPassword;
  String ownerPassword;
  // A bit-field containing file permissions.
  int permissions = PDFWriter.ALLOW_PRINTING | PDFWriter.ALLOW_COPY;

  PdfReader reader = new PdfReader(inputFile);
  PdfEncryptor.encrypt(reader, new FileOutputStream(outputFile),
      ENCRYPTION_AES128, userPassword, ownerPassword, 
      permissions);