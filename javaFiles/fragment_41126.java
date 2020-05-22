Paint paint = new Paint();
paint.setStyle(Style.FILL);
// set other paint parameters, like color...
...

Path path = new Path();
path.moveTo(startX, startY);
path.lineTo(startX, startY + 50);
path.lineTo(startX+50, startY + 50);
path.lineTo(startX+50, startY);
canvas.drawPath(path, paint);