// Prepare
POIFSFileSystem fs = new POIFSFileSystem();
EncryptionInfo info = new EncryptionInfo(EncryptionMode.agile, CipherAlgorithm.aes192, HashAlgorithm.sha384, -1, -1, null);

Encryptor enc = info.getEncryptor();
enc.confirmPassword("foobaa");

// Create the normal workbook
Workbook wb = new XSSFWorkbook();
Sheet s = wb.createSheet();
// TODO Populate

// Encrypt
OutputStream os = enc.getDataStream(fs);
wb.save(os);
opc.close();

// Save
FileOutputStream fos = new FileOutputStream("protected.xlsx");
fs.writeFilesystem(fos);
fos.close();