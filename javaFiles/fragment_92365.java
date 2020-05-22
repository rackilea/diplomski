int cx = (getWidth() - newWidth) / 2;
int cy = (getHeight() - newHeight) / 2;

Rect src = new Rect(0, 0, myBitmap.getWidth() - 1, myBitmap.getHeight() - 1);
Rect dest = new Rect(cx, cy, cx+Math.round(newWidth), cy+Math.round(newHeight));
canvas.drawBitmap(myBitmap, src, dest, null);