public Drawable getRoundRect() {
    RoundRectShape rectShape = new RoundRectShape(new float[]{
            10, 10, 10, 10,
            10, 10, 10, 10
    }, null, null);

    ShapeDrawable shapeDrawable = new ShapeDrawable(rectShape);
    shapeDrawable.getPaint().setColor(Color.parseColor("#FF0000"));
    shapeDrawable.getPaint().setStyle(Paint.Style.FILL);
    shapeDrawable.getPaint().setAntiAlias(true);
    shapeDrawable.getPaint().setFlags(Paint.ANTI_ALIAS_FLAG);
    return shapeDrawable;
}