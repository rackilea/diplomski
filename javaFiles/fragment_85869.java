class V extends View {
    Bitmap bitmap;
    Paint paint = new Paint();

    public V(Context context) {
        super(context);
        bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.chrome);
        Shader shaderA = new LinearGradient(0, 0, bitmap.getWidth(), 0, 0xffffffff, 0x00ffffff, Shader.TileMode.CLAMP);
        Shader shaderB = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        paint.setShader(new ComposeShader(shaderA, shaderB, PorterDuff.Mode.SRC_IN));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawRect(0, 0, bitmap.getWidth(), bitmap.getHeight(), paint);
    }
}