public class DrawMapView extends MapView implements OnMapReadyCallback{

    private float DIAMOND_WIDTH = 42;
    private float DIAMOND_HEIGHT = 18;
    private float DIAMOND_ADVANCE = 1.5f * DIAMOND_WIDTH;       // spacing between each stamp of shape
    private float DIAMOND_PHASE = DIAMOND_WIDTH / 2;            // amount to offset before the first shape is stamped
    private float DIAMOND_BORDER_WIDTH = 6;                     // width of diamond border

    private Path mBorderPath;
    private Path mPathDiamondStamp;
    private Paint mDiamondPaint;
    private OnMapReadyCallback mMapReadyCallback;
    private MapboxMap mMapboxMap = null;
    private List<LatLng> mBorderPoints;

    public DrawMapView(@NonNull Context context) {
        super(context);
        init();
    }

    public DrawMapView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public DrawMapView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public DrawMapView(@NonNull Context context, @Nullable MapboxMapOptions options) {
        super(context, options);
        init();
    }

    public void setBorderPoints(List<LatLng> borderPoints) {
        mBorderPoints = borderPoints;
    }

    @Override
    public void getMapAsync(OnMapReadyCallback callback) {
        mMapReadyCallback = callback;
        super.getMapAsync(this);
    }

    @Override
    public void onMapReady(MapboxMap mapboxMap) {
        mMapboxMap = mapboxMap;
        if (mMapReadyCallback != null) {
            mMapReadyCallback.onMapReady(mapboxMap);
        }
    }

    @Override
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        canvas.save();
        drawDiamondsPath(canvas);
        canvas.restore();
    }

    private void drawDiamondsPath(Canvas canvas) {
        if (mBorderPoints == null || mBorderPoints.size() == 0) {
            return;
        }

        mBorderPath = new Path();

        LatLng firstBorderPoint = mBorderPoints.get(0);
        PointF firstScreenPoint = mMapboxMap.getProjection().toScreenLocation(firstBorderPoint);
        mBorderPath.moveTo(firstScreenPoint.x, firstScreenPoint.y);

        for (int ixPoint = 1; ixPoint < mBorderPoints.size(); ixPoint++) {
            PointF currentScreenPoint = mMapboxMap.getProjection().toScreenLocation(mBorderPoints.get(ixPoint));
            mBorderPath.lineTo(currentScreenPoint.x, currentScreenPoint.y);
        }

        mPathDiamondStamp = new Path();
        mPathDiamondStamp.moveTo(-DIAMOND_WIDTH / 2, 0);
        mPathDiamondStamp.lineTo(0, DIAMOND_HEIGHT / 2);
        mPathDiamondStamp.lineTo(DIAMOND_WIDTH / 2, 0);
        mPathDiamondStamp.lineTo(0, -DIAMOND_HEIGHT / 2);
        mPathDiamondStamp.close();

        mPathDiamondStamp.moveTo(-DIAMOND_WIDTH / 2 + DIAMOND_BORDER_WIDTH, 0);
        mPathDiamondStamp.lineTo(0, -DIAMOND_HEIGHT / 2 + DIAMOND_BORDER_WIDTH / 2);
        mPathDiamondStamp.lineTo(DIAMOND_WIDTH / 2 - DIAMOND_BORDER_WIDTH, 0);
        mPathDiamondStamp.lineTo(0, DIAMOND_HEIGHT / 2 - DIAMOND_BORDER_WIDTH / 2);
        mPathDiamondStamp.close();

        mPathDiamondStamp.setFillType(Path.FillType.EVEN_ODD);

        mDiamondPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mDiamondPaint.setColor(Color.BLUE);
        mDiamondPaint.setStrokeWidth(2);
        mDiamondPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        mDiamondPaint.setStyle(Paint.Style.STROKE);
        mDiamondPaint.setPathEffect(new PathDashPathEffect(mPathDiamondStamp, DIAMOND_ADVANCE, DIAMOND_PHASE, PathDashPathEffect.Style.ROTATE));

        canvas.drawPath(mBorderPath, mDiamondPaint);
    }

    private void init() {
        mBorderPath = new Path();
        mPathDiamondStamp = new Path();
    }
}