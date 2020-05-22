canvas.save();
for (int i = 0; i < 12; i++) {
    canvas.rotate(30, screenCenterX, screenCenterY);
    canvas.drawPath(path, paint);
}
canvas.restore();