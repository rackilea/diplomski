int a = view1.getMeasuredWidth();
int b = view1.getMeasuredHeight();
int c = view2.getMeasuredWidth();
int d = view2.getMeasuredHeight();

Bitmap b1 = Bitmap.createBitmap(a, b, Bitmap.Config.ARGB_8888);
Bitmap b2 = Bitmap.createBitmap(c, d, Bitmap.Config.ARGB_8888);
Bitmap b3 = Bitmap.createBitmap(a, b + d, Bitmap.Config.ARGB_8888);