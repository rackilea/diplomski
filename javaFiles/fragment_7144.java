int borderRadius = 15;
Path path = new Path();
path.moveTo(borderRadius , 0);
path.lineTo(width-borderRadius, 0); // top side
path.quadTo(width, 0, width, borderRadius); // top right corner
path.lineTo(width, height-borderRadius); // right side
path.quadTo(width, height, width-borderRadius, height); // bottom right corner
...
path.close();