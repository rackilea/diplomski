public static int[] getColors(int size) {

    LinearGradient gradient = new LinearGradient(0, 0, size, 1,
            new int[] {
                    0xffffbb33,
                    0xffffbb33,
                    0xff99cc00,
                    0xffaa66cc,
                    0xFF33b5e5 },
            new float[] {
                    0f, 0.2f, 0.4f, 0.6f, 1f },
            Shader.TileMode.CLAMP);

    Paint p = new Paint();
    p.setStyle(Paint.Style.FILL);
    p.setShader(gradient);

    Bitmap bitmap = Bitmap.createBitmap(size, 1, Bitmap.Config.ARGB_8888);
    Canvas canvas = new Canvas(bitmap);
    canvas.drawRect(0, 0, size, 1, p);

    int[] colors = new int[size];
    bitmap.getPixels(colors, 0, size, 0, 0, size, 1);
    bitmap.recycle();
    return colors;
}