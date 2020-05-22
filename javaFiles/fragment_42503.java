Canvas c1 = new Canvas(b1);
view1.draw(c1);

Canvas c2 = new Canvas(b2);
view2.draw(c2);

Canvas canvas = new Canvas(b3);

canvas.drawBitmap(b2, new Matrix(), null);
canvas.drawBitmap(b1, 0, view2.getHeight(), null);