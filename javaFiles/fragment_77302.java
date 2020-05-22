try {
    Bitmap bmp = encodeToQrCode("Hello world", 200, 200);
    if (bmp != null ) {
        byte[] command = Utils.decodeBitmap(bmp);
        BluetoothPrintDriver.BT_Write(command);
    }else{
        Log.e("Print Photo error", "the file isn't exists");
    }
} catch (Exception e) {
    e.printStackTrace();
    Log.e("PrintTools", "the file isn't exists");
}