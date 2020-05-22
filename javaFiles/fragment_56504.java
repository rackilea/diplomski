public class MyRelativeLayout extends RelativeLayout {    
    public MyRelativeLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public MyRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyRelativeLayout(Context context) {
        super(context);
        init();
    }

    private void init() {
        setStaticTransformationsEnabled(true);
    }

    @Override
    protected boolean getChildStaticTransformation(View child, Transformation t) {
        t.setTransformationType(Transformation.TYPE_MATRIX);
        Matrix m = t.getMatrix();
        m.reset();
        m.postRotate(180, child.getWidth() / 2.0f, child.getHeight() / 2.0f);
        return true;
    }
}