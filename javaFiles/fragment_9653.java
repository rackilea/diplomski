public static byte[] decodeBitmap(byte[] bitmapBytes) {

    Bitmap bmp = BitmapFactory.decodeByteArray(bitmapBytes, 0, bitmapBytes.length);

    int zeroCount = bmp.getWidth() % 8;
    String zeroStr = "";
    if (zeroCount > 0) {
        for (int i = 0; i < (8 - zeroCount); i++) {
            zeroStr = zeroStr + "0";
        }
    }

    List<String> list = new ArrayList<>();
    for (int i = 0; i < bmp.getHeight(); i++) {
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < bmp.getWidth(); j++) {
            int color = bmp.getPixel(j, i);

            int r = (color >> 16) & 0xff;
            int g = (color >> 8) & 0xff;
            int b = color & 0xff;

            // if color close to white，bit='0', else bit='1'
            if (r > 160 && g > 160 && b > 160)
                sb.append("0");
            else
                sb.append("1");
        }
        if (zeroCount > 0) {
            sb.append(zeroStr);
        }

        list.add(sb.toString());
    }

    List<String> bmpHexList = binaryListToHexStringList(list);
    List<String> commandList = new ArrayList<>();
    commandList.addAll(bmpHexList);

    return hexListToBytes(commandList);
}