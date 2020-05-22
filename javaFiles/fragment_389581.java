deltaX = this.mPoints[1].x - this.mPoints[3].x;
deltaY = this.mPoints[1].y - this.mPoints[3].y;

frac = (float) 0.1;

point_x_1 = this.mPoints[3].x + (1 - frac) * deltaX + frac * deltaY;
point_y_1 = this.mPoints[3].y + (1 - frac) * deltaY - frac * deltaX;

point_x_2 = this.mPoints[1].x;
point_y_2 = this.mPoints[1].y;

point_x_3 = this.mPoints[3].x + (1 - frac) * deltaX - frac * deltaY;
point_y_3 = this.mPoints[3].y + (1 - frac) * deltaY + frac * deltaX;

line_end_x = this.mPoints[1].x - frac * deltaX; // This
line_end_y = this.mPoints[1].y - frac * deltaY;

Path path = new Path();
path.setFillType(Path.FillType.EVEN_ODD);
path.moveTo(point_x_1,  point_y_1);
path.lineTo(point_x_2, point_y_2);
path.lineTo(point_x_3, point_y_3);
path.lineTo(point_x_1, point_y_1);
path.lineTo(point_x_1, point_y_1);

path.close();

// line_end_* instead of this.mPoints[1].*
canvas.drawLine(this.mPoints[3].x, this.mPoints[3].y, line_end_x, line_end_y, this.mPaint);
canvas.drawPath(path, mPaint);