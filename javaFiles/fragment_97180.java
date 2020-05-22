public class CircleSurface extends SurfaceView {

    private Path clipPath;

    public CircleSurface(Context context) {
        super(context);
        init();
    }

    public CircleSurface(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CircleSurface(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        clipPath = new Path();
        //TODO: define the circle you actually want
        clipPath.addCircle(710, 330, 250, Path.Direction.CW);
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        canvas.clipPath(clipPath);
        super.dispatchDraw(canvas);
    }
}