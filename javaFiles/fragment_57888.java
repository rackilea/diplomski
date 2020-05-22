class V extends View implements MatrixGestureDetector.OnMatrixChangeListener {
    Paint monoPaint = new Paint();
    Paint srcInPaint = new Paint();
    Bitmap mask, maskShadow, bitmap, blur;
    Matrix matrix = new Matrix();
    Matrix maskMatrix = new Matrix();
    MatrixGestureDetector detector;
    RectF clip = new RectF();

    public V(Context context) {
        super(context);
        mask = BitmapFactory.decodeResource(context.getResources(), R.drawable.mask).extractAlpha();
        maskShadow = BitmapFactory.decodeResource(context.getResources(), R.drawable.mask_shadow);
        bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.forest);
        blur = blur(context, bitmap, 8);
        ColorMatrix cm = new ColorMatrix();
        cm.setSaturation(0.25f);
        monoPaint.setColorFilter(new ColorMatrixColorFilter(cm));
        srcInPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        detector = new MatrixGestureDetector(maskMatrix, this);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        RectF src = new RectF(0, 0, bitmap.getWidth(), bitmap.getHeight());
        RectF dst = new RectF(0, 0, w, h);
        matrix.setRectToRect(src, dst, Matrix.ScaleToFit.CENTER);
        matrix.mapRect(dst, src);

        src.set(0, 0, mask.getWidth(), mask.getHeight());
        maskMatrix.setRectToRect(src, dst, Matrix.ScaleToFit.CENTER);
        setupClip();
    }

    private void setupClip() {
        clip.set(0, 0, mask.getWidth(), mask.getHeight());
        maskMatrix.mapRect(clip);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawBitmap(blur, matrix, monoPaint);
        drawMask(canvas);
    }

    private void drawMask(Canvas canvas) {
        canvas.clipRect(clip);
        canvas.saveLayer(clip, null, 0);
        canvas.drawBitmap(mask, maskMatrix, null);
        canvas.drawBitmap(bitmap, matrix, srcInPaint);
        canvas.drawBitmap(maskShadow, maskMatrix, null);
        canvas.restore();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        detector.onTouchEvent(event);
        return true;
    }

    @Override
    public void onChange(Matrix matrix) {
        setupClip();
        invalidate();
    }

    Bitmap blur(Context ctx, Bitmap src, float radius) {
        Bitmap bitmap = src.copy(src.getConfig(), true);

        RenderScript renderScript = RenderScript.create(ctx);
        Allocation blurInput = Allocation.createFromBitmap(renderScript, src);
        Allocation blurOutput = Allocation.createFromBitmap(renderScript, bitmap);

        ScriptIntrinsicBlur blur = ScriptIntrinsicBlur.create(renderScript, Element.U8_4(renderScript));
        blur.setInput(blurInput);
        blur.setRadius(radius);
        blur.forEach(blurOutput);

        blurOutput.copyTo(bitmap);
        renderScript.destroy();
        return bitmap;
    }
}