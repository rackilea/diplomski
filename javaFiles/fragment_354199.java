// create QR code
    BitMatrix bitMatrix = new QRCodeWriter().encode("Text in QRCode", BarcodeFormat.QR_CODE, 15, 15);
    // save as image
    String path = "path/on/disc"
    File img = new File(path);
    FileOutputStream fos = new FileOutputStream(img);
    MatrixToImageWriter.writeToStream(bitMatrix, "gif", fos);
    fos.close();