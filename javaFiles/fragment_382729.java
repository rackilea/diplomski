@Override
public void onDraw(Canvas canvas) {
    for (Line l : lines) {
        canvas.drawLine(l.x1, l.y1, l.x2, l.y2, paint);
    }
}