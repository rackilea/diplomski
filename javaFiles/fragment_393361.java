public class MyDrawableView extends View {
private Drawable mD1;
private Drawable mD2;

public MyDrawableView(Context context) {
    super(context);

    Resources res = context.getResources();
    mD1 = res.getDrawable(R.drawable.image1);
    //Set image1 bounds using : mD1.setBounds(x, y, x + width, y + height);

    mD2 = res.getDrawable(R.drawable.image2);
    //Set image2 bounds using : mD2.setBounds(a, b, a + width, b + height);
}

protected void onDraw(Canvas canvas) {
    mD1.draw(canvas);
    mD2.draw(canvas);
}
}