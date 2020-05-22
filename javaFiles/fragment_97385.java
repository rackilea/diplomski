private List<MyAttributes> mAttributes;
private Random mRandom;

public MyViewCircle(Context context) {
    mRandom = new Random();
    mAttributes = new ArrayList<MyAttributes>();

    mAttributes.add(new MyAttributes(Color.RED, 80, 70, 199));
    mAttributes.add(new MyAttributes(Color.BLUE, 50, 170, 88));
}


@Override
protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);
    Paint paint = new Paint();
    paint.setAntiAlias(true);

    int randomPosition = mRandom.nextInt(mAttributes.size());
    MyAttributes randomAttr = mAttributes.get(randomPosition);

    paint.setColor(randomAttr.color);
    canvas.drawCircle(randomAttr.x, randomAttr.y, randomAttr.radius, paint);
}