class V extends View implements MatrixGestureDetector.OnMatrixChangeListener {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Paint monoPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Paint borderPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap bitmap, blur;
    Matrix matrix = new Matrix();
    Matrix pathMatrix = new Matrix();
    Path path = new Path();
    Path transformedPath = new Path();
    MatrixGestureDetector detector;
    RectF clip = new RectF();

    public V(Context context) {
        super(context);
        bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.forest);
        blur = blur(context, bitmap, 8);
        ColorMatrix cm = new ColorMatrix();
        cm.setSaturation(0.25f);
        monoPaint.setColorFilter(new ColorMatrixColorFilter(cm));
        borderPaint.setStyle(Paint.Style.STROKE);
        borderPaint.setColor(0xccffffff);
        borderPaint.setStrokeWidth(4);
        detector = new MatrixGestureDetector(pathMatrix, this);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        Shader shader = new BitmapShader(bitmap, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        RectF src = new RectF(0, 0, bitmap.getWidth(), bitmap.getHeight());
        RectF dst = new RectF(0, 0, w, h);
        matrix.setRectToRect(src, dst, Matrix.ScaleToFit.CENTER);
        shader.setLocalMatrix(matrix);
        paint.setShader(shader);
        matrix.mapRect(clip, src);
        createPath();
    }

    private void createPath() {
        path.reset();
        path.moveTo(114, 156);
        float[] points = {68, 138, 19, 136, 21, 87, 8, 39, 56, 26, 97, -2, 123, 40, 163, 71, 131, 109};
        for (int i = 0; i < points.length; i += 2) {
            path.lineTo(points[i], points[i + 1]);
        }
        path.close();
        Matrix m = new Matrix();
        m.setRectToRect(new RectF(0, 0, 160, 160), clip, Matrix.ScaleToFit.CENTER);
        path.transform(m);
        transformedPath.set(path);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawBitmap(blur, matrix, monoPaint);
        canvas.save();
        canvas.clipRect(clip);
        canvas.drawPath(transformedPath, paint);
        canvas.restore();
        canvas.drawPath(transformedPath, borderPaint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        detector.onTouchEvent(event);
        return true;
    }

    @Override
    public void onChange(Matrix matrix) {
        path.transform(matrix, transformedPath);
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

class MatrixGestureDetector {
    private static final String TAG = "MatrixGestureDetector";

    interface OnMatrixChangeListener {
        void onChange(Matrix matrix);
    }

    private int ptpIdx = 0;
    private Matrix mTempMatrix = new Matrix();
    private Matrix mMatrix;
    private OnMatrixChangeListener mListener;
    private float[] mSrc = new float[4];
    private float[] mDst = new float[4];
    private int mCount;

    public MatrixGestureDetector(Matrix matrix, MatrixGestureDetector.OnMatrixChangeListener listener) {
        if (matrix == null) throw new RuntimeException("Matrix cannot be null");
        if (listener == null) throw new RuntimeException("OnMatrixChangeListener cannot be null");
        mMatrix = matrix;
        mListener = listener;
    }

    public void onTouchEvent(MotionEvent event) {
        if (event.getPointerCount() > 2) {
            return;
        }

        int action = event.getActionMasked();
        int index = event.getActionIndex();

        switch (action) {
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_POINTER_DOWN:
                int idx = index * 2;
                mSrc[idx] = event.getX(index);
                mSrc[idx + 1] = event.getY(index);
                mCount++;
                ptpIdx = 0;
                break;

            case MotionEvent.ACTION_MOVE:
                for (int i = 0; i < mCount; i++) {
                    idx = ptpIdx + i * 2;
                    mDst[idx] = event.getX(i);
                    mDst[idx + 1] = event.getY(i);
                }
                mTempMatrix.setPolyToPoly(mSrc, ptpIdx, mDst, ptpIdx, mCount);
                mMatrix.postConcat(mTempMatrix);
                mListener.onChange(mMatrix);
                System.arraycopy(mDst, 0, mSrc, 0, mDst.length);
                break;

            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_POINTER_UP:
                if (event.getPointerId(index) == 0) ptpIdx = 2;
                mCount--;
                break;
        }
    }
}