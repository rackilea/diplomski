moveTo(0, height);
lineTo(0, radius);
curveTo(0, 0, 0, 0, radius, 0);
lineTo(width - radius, 0);
curveTo(width, 0, width, 0, width, radius);
lineTo(width, height);
closePath();