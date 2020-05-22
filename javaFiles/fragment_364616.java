@Override
protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);

    paint.setColor(Color.RED);
    paint.setStyle(Paint.Style.FILL);

    p.moveTo(0, 0);
    p.lineTo(180, 0);
    p.moveTo(180, 0);
    p.cubicTo(246, 227, 127, 24, 115, 150);
    p.cubicTo(127, 276, 246, 71, 180, 300);
    p.moveTo(180, 300);
    p.cubicTo(44, 261, 166, 332, 90, 339);
    p.cubicTo(14, 332, 136, 261, 0, 300);
    p.moveTo(0, 300);
    p.lineTo(0, 0);

    canvas.drawPath(p, paint);
}