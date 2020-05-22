public Bitmap encodeToQrCode(String text, int width, int height){
    QRCodeWriter writer = new QRCodeWriter();
    BitMatrix matrix = null;
    try {
        matrix = writer.encode(text, BarcodeFormat.QR_CODE, width, height);
    } catch (WriterException ex) {
        //
    }
    Bitmap bmp = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565);
    for (int x = 0; x < width; x++){
        for (int y = 0; y < height; y++){
            bmp.setPixel(x, y, matrix.get(x,y) ? Color.BLACK : Color.WHITE);
        }
    }
    return bmp;
}