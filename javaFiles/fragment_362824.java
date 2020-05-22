public class WarpView extends View {
    static {
        System.loadLibrary("Hello");
    }

    public native int[] warpPhotoFromC(int[] image, int height, int width,
            double max_dist, double orig_x, double orig_y, double cur_x,
            double cur_y);

    private static String TAG = WarpView.class.getSimpleName();

    private Bitmap mBmp;
    private int[] image;
    private int first = 0;
    private int[] colorR;
    private int[] colorG;
    private int[] colorB;
    private Bitmap newBmp;
    private boolean fg = true;
    private Context context;

    private static final int DEFAULT_PAINT_FLAGS = Paint.FILTER_BITMAP_FLAG
            | Paint.DITHER_FLAG;
    static Paint mPaint = new Paint(DEFAULT_PAINT_FLAGS);

    public static int HWPPQ = 110;
    public static int MMQFJ = 120;

    private int MODE = MMQFJ;

    // SA VIKALP
//  public ArrayList<WarpViewUndo> mArrayListWarpViewUndo;

    static GestureDetector mGestures;
    static ScaleGestureDetector mScaleGesture;

    private Matrix mMatrix = new Matrix();
    private Matrix mInverse = new Matrix();

    private float lastFocusX;
    private float lastFocusY;

    private boolean mIsMove = false;

    // EA VIKALP
    public WarpView(Context context) {
        super(context);
    }

    public WarpView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        dest = new RectF(0, 0, 0, 0);

        // SA VIKALP
//      mArrayListWarpViewUndo = new ArrayList<WarpViewUndo>();
        mScaleGesture = new ScaleGestureDetector(getContext(),
                new ScaleListener());
        mGestures = new GestureDetector(getContext(), new GestureListener());

        mMatrix.setTranslate(5, 5);
        mMatrix.invert(mInverse);
        // EA VIKALP
    }

    @Override
    protected void onDraw(Canvas canvas) {
        // super.onDraw(canvas);
        if (fg) {
            int viewWidht = getWidth();
            int viewHeight = getHeight();
            float scale1 = (float) width / (float) viewWidht;
            float scale2 = (float) height / (float) viewHeight;
            scale = scale1 > scale2 ? scale1 : scale2;
            int xoffset = (viewWidht - (int) (width / scale)) / 2;
            int yoffset = (viewHeight - (int) (height / scale)) / 2;
            dest.set(xoffset, yoffset, (int) (width / scale) + xoffset,
                    (int) (height / scale) + yoffset);// = new RectF(xoffset,
                                                        // yoffset, (int)
                                                        // (width/scale)+xoffset,
                                                        // (int)
                                                        // (height/scale)+yoffset);
            // SA VIKALP
            canvas.drawColor(0x000000);
            canvas.concat(mMatrix);
            // canvas.drawColor(Color.TRANSPARENT);
            // canvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);
            // EA VIKALP
            canvas.drawBitmap(mBmp, null, dest, mPaint);

        } else {
            // SA VIKALP
            canvas.drawColor(0x000000);
            canvas.concat(mMatrix);
            // canvas.drawColor(Color.TRANSPARENT);
            // canvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);
            // EA VIKALP
            canvas.drawBitmap(newBmp, null, dest, mPaint);
        }
    }

    private double orig_x, orig_y;
    private double mou_dx, mou_dy;
    private double max_dist, max_dist_sq;
    private int width;
    private int height;
    private int count = 0;
    private double mou_dx_norm;
    private double mou_dy_norm;

    private float scale;
    private RectF dest;
    private double move_x, move_y;
    private int dist = (int) getResources().getDimension(R.dimen.max_dist);
    private int line_height = (int) getResources().getDimension(
            R.dimen.warp_line);

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // SA VIKALP
        mScaleGesture.onTouchEvent(event);
        mGestures.onTouchEvent(event);
        // EA VIKALP

        switch (event.getAction()) {
        case MotionEvent.ACTION_DOWN:
            orig_x = event.getX();
            orig_y = event.getY();
            orig_x = (orig_x - dest.left) * scale;
            orig_y = (orig_y - dest.top) * scale;

            break;
        case MotionEvent.ACTION_MOVE:
            if (!mIsMove) { // SA VIKALP ADDED LINE
                max_dist = dist * scale;// Math.hypot(mou_dx, mou_dy);
                if (event.getAction() != 1) {


                    // int m = event.getHistorySize();

                    move_x = event.getX();
                    move_y = event.getY();

                    move_x = (move_x - dest.left) * scale;
                    move_y = (move_y - dest.top) * scale;

                    // if(m > 0){
                    // int i2 = m + -1;
                    // orig_x = (event.getHistoricalX(i2) - dest.left)*scale;
                    // orig_y = (event.getHistoricalY(i2) - dest.top)*scale;
                    // }

                    if (move_x >= 0 && move_y >= 0) {
                            warpPhotoFromC(image, height, width, max_dist, orig_x,
                                    orig_y, move_x, move_y);
                        first++;

                        newBmp.setPixels(image, 0, width, 0, 0, width, height);
                        fg = false;
                    }
                }
                orig_x = move_x;
                orig_y = move_y;

            } 
            break;
        case MotionEvent.ACTION_UP:
            break;
        }
        invalidate();
        return true;
    }
    // SA VIKALP
//  public void applyWarpUndo(Bitmap bmp) {
//      setWarpBitmap(bmp);
//      Log.i(TAG, "Size : "
//              + mArrayListWarpViewUndo.size()
//              + " last size :"
//              + mArrayListWarpViewUndo.get(mArrayListWarpViewUndo.size() - 1)
//                      .getSize() + 1);
//      
//      for (int i = 0; i < mArrayListWarpViewUndo.size() - (mArrayListWarpViewUndo.get(mArrayListWarpViewUndo.size() - 1).getSize()+1); i++) {
//          if (mArrayListWarpViewUndo.get(i).getMove_x() >= 0 && mArrayListWarpViewUndo.get(i).getMove_y() >= 0) {
//              warpPhotoFromC(mArrayListWarpViewUndo.get(i).getImage(),
//                      mArrayListWarpViewUndo.get(i).getHeight(),
//                      mArrayListWarpViewUndo.get(i).getWidth(),
//                      mArrayListWarpViewUndo.get(i).getMax_dist(),
//                      mArrayListWarpViewUndo.get(i).getOrig_x(),
//                      mArrayListWarpViewUndo.get(i).getOrig_y(),
//                      mArrayListWarpViewUndo.get(i).getMove_x(),
//                      mArrayListWarpViewUndo.get(i).getMove_y());
//
//              newBmp.setPixels(mArrayListWarpViewUndo.get(i).getImage(), 0,
//                      mArrayListWarpViewUndo.get(i).getWidth(), 0, 0,
//                      mArrayListWarpViewUndo.get(i).getWidth(),
//                      mArrayListWarpViewUndo.get(i).getHeight());
//              fg = false;
//          }
//      }
////        Log.i(TAG, "Step Size "+mArrayListWarpViewUndo.size()-1);
//      mArrayListWarpViewUndo.remove(mArrayListWarpViewUndo.size()-2);
//      invalidate();
//  }
    public class ScaleListener implements OnScaleGestureListener {

        @Override
        public boolean onScale(ScaleGestureDetector detector) {
            // TODO Auto-generated method stub
            Matrix transformationMatrix = new Matrix();
            float focusX = detector.getFocusX();
            float focusY = detector.getFocusY();

            // Zoom focus is where the fingers are centered,
            transformationMatrix.postTranslate(-focusX, -focusY);

            transformationMatrix.postScale(detector.getScaleFactor(),
                    detector.getScaleFactor());

            /*
             * Adding focus shift to allow for scrolling with two pointers down.
             * Remove it to skip this functionality. This could be done in fewer
             * lines, but for clarity I do it this way here
             */
            // Edited after comment by chochim
            float focusShiftX = focusX - lastFocusX;
            float focusShiftY = focusY - lastFocusY;
            transformationMatrix.postTranslate(focusX + focusShiftX, focusY
                    + focusShiftY);
            mMatrix.postConcat(transformationMatrix);
            lastFocusX = focusX;
            lastFocusY = focusY;
            invalidate();
            return true;
        }

        @Override
        public boolean onScaleBegin(ScaleGestureDetector detector) {
            // TODO Auto-generated method stub
            lastFocusX = detector.getFocusX();
            lastFocusY = detector.getFocusY();
            return true;
        }

        @Override
        public void onScaleEnd(ScaleGestureDetector detector) {
            // TODO Auto-generated method stub

        }
    }

    public class GestureListener implements OnGestureListener,
            OnDoubleTapListener {

        @Override
        public boolean onDoubleTap(MotionEvent arg0) {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public boolean onDoubleTapEvent(MotionEvent arg0) {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public boolean onSingleTapConfirmed(MotionEvent arg0) {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public boolean onDown(MotionEvent e) {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
                float velocityY) {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public void onLongPress(MotionEvent e) {
            // TODO Auto-generated method stub

        }

        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2,
                float distanceX, float distanceY) {
            // TODO Auto-generated method stub
            if (mIsMove) {
                mMatrix.postTranslate(-distanceX, -distanceY);
                invalidate();
            }
            return true;
        }

        @Override
        public void onShowPress(MotionEvent e) {
            // TODO Auto-generated method stub

        }

        @Override
        public boolean onSingleTapUp(MotionEvent e) {
            // TODO Auto-generated method stub
            return false;
        }
    }

    public void setMove(boolean isMove) {
        mIsMove = isMove;
    }

    // EA VIKALP

    public void setWarpBitmap(Bitmap bmp) {
        fg = true;// é‡�ç½®æ ‡å¿—
        first = 0;
        mBmp = bmp;
        width = bmp.getWidth();
        height = bmp.getHeight();
        // æ–°å»ºï¿½?ï¿½ï¿½Bitmap
        // SU VIKALP
        // newBmp = Bitmap.createBitmap(width, height,
        // Bitmap.Config.RGB_565);
        newBmp = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        // EU VIKALP
        image = new int[width * height];

        mBmp.getPixels(image, 0, width, 0, 0, width, height);
        newBmp.setPixels(image, 0, width, 0, 0, width, height);
        // super.setImageBitmap(mBmp);
    }

    public void setMode(int mode) {
        this.MODE = mode;
    }

    /**
     * è¿�?å›žå¤„ç�†å¥½çš„å›¾ç‰‡
     * 
     * @return
     */
    public Bitmap getWrapBitmap() {
        return newBmp;
    }

    public void changeBitmapContrastBrightness() {
        float contrast, brightness;
        Random generator = new Random();
        contrast = generator.nextFloat();
        brightness = contrast;

        // Log.i(TAG, "changeBitmapContrastBrightness " + contrast);

        ColorMatrix cm = new ColorMatrix(new float[] { 
                0.501f, 0, 0, 0,0,// red
                0, 0, 0, 0, brightness,// green
                0, 0, 0.501f, 0, brightness,// blue
                0, 0, 0, 1, 0 // alpha
                });
        mPaint.setColorFilter(new ColorMatrixColorFilter(cm));
        invalidate();
    }
}