Bitmap BitRed = ((BitmapDrawable)getResources().getDrawable(R.drawable.redsquare)).getBitmap();

Bitmap BitClick = ((BitmapDrawable) v.getBackground()).getBitmap();

if (BitClick.sameAs(BitRed)) 
{ 
    //Your Button with Red Square Clicked
}