@Override
public void dispatchDraw(Canvas canvas) {
    super.dispatchDraw(canvas);
    canvas.save();
    drawDiamondsPath(canvas);
    canvas.restore();
}