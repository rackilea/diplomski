Bitmap myCoolBitmap = ... ; // <-- Your bitmap you want rounded    
int w = myCoolBitmap.getWidth(), h = myCoolBitmap.getHeight();

// We have to make sure our rounded corners have an alpha channel in most cases
Bitmap rounder = Bitmap.createBitmap(w,h,Bitmap.Config.ARGB_8888);
Canvas canvas = new Canvas(rounder);    

// We're going to apply this paint eventually using a porter-duff xfer mode.
// This will allow us to only overwrite certain pixels. RED is arbitrary. This
// could be any color that was fully opaque (alpha = 255)
Paint xferPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
xferPaint.setColor(Color.RED);

// We're just reusing xferPaint to paint a normal looking rounded box, the 20.f
// is the amount we're rounding by.
canvas.drawRoundRect(new RectF(0,0,w,h), 20.0f, 20.0f, xferPaint);     

// Now we apply the 'magic sauce' to the paint  
xferPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));