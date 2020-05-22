String contents = "Code";
BarCodeFormat barcodeFormat = BarCodeFormat.QR_CODE;

int width = 300;
int height = 300;

MultiFormatWriter barcodeWriter = new MultiFormatWriter();
BitMatrix matrix = barcodeWriter.encode(contents, barcodeFormat, width, height);
BufferedImage qrCodeImg = MatrixToImageWriter.toBufferedImage(matrix);