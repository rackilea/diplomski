public class Background extends View {

    private static final int BORDER_WIDTH = 2; //in px

    private int[] points; //2n = x, 2n+1 = y

    public Background(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        for(Drawable drawable : drawBackground()){
            drawable.draw(canvas);
        }
    }

    private Drawable[] drawBackground() {
        Drawable[] drawables = new Drawable[2];

        int width = getWidth();
        int height = getHeight();
        int corner = width / 4;

        //draw border
        Path path = new Path();
        path.moveTo(0, corner);
        path.lineTo(corner, 0);
        path.lineTo(width, 0);
        path.lineTo(width, height - corner);
        path.lineTo(width - corner, height);
        path.lineTo(0, height);
        path.close();

        drawables[0] = new ShapeDrawable(new PathShape(path, width, height));
        drawables[0].setBounds(0, 0, width, height);

        //draw inside the border
        points = {
            BORDER_WIDTH, corner,
            corner, BORDER_WIDTH,
            width - BORDER_WIDTH, BORDER_WIDTH,
            width - BORDER_WIDTH, height - corner,
            width - corner, height - BORDER_WIDTH,
            BORDER_WIDTH, height - BORDER_WIDTH
        }
        path = new Path();
        path.moveTo(points[0], points[1]);
        for (int i = 2, i < points.length, i++) {
            path.lineTo(points[i], points[++i]);
        }
        path.close();

        ShapeDrawable shapeDrawable = new ShapeDrawable(new PathShape(path, width, height));
        shapeDrawable.getPaint().setColor(Color.rgb(238, 238, 238));
        shapeDrawable.setBounds(0, 0, width, height);
        drawables[1] = shapeDrawable;

        return drawables;
    }

    public Point[] getPoints() {
        return points;
    }
}