public class PartiallyTransparentLayout extends ConstraintLayout {
    private Path clipPath = null;

    public PartiallyTransparentLayout(Context c) {
        super(c);
    }

    public PartiallyTransparentLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PartiallyTransparentLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    // Intercept the drawChild call and set a custom clipping for all following drawing operations
    @Override
    protected boolean drawChild(Canvas canvas, View child, long drawingTime) {
        // Our clipPath specifies the area we are NOT allowed to draw in, inversing the clipping
        // is different on higher Android versions.
        if (clipPath != null) {
            if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                canvas.clipOutPath(clipPath);
            } else {
                canvas.clipPath(clipPath, Region.Op.DIFFERENCE);
            }
        }

        // Let the framework continue as if nothing happened.
        return super.drawChild(canvas, child, drawingTime);
    }

    // Specify the custom clipping
    public void setClipping(Path p) {
        clipPath = p;

        // Every time the clip changes, every view needs to redraw to account for it.
        invalidate();
    }
}