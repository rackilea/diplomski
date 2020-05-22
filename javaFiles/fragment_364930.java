import android.graphics.Rect;

imageView1 = (ImageView) findViewById(R.id.imageView1);
imageView2 = (ImageView) findViewById(R.id.imageView2);

Rect rect1 = new Rect();
imageView1.getDrawingRect(rect1);

Rect rect2 = new Rect();
imageView2.getDrawingRect(rect2);

if (Rect.intersects(rect1, rect2) {
   //intersected
}