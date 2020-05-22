@Override
protected synchronized void onDraw(Canvas canvas)
{
    if(bitmap != null && bitmap.getHeight() > getHeight())
    {
        canvas.clipRect(0, 0, getWidth(), bitmap.getHeight(), Region.Op.REPLACE); 

        bounds = getProgressDrawable().getBounds();
        bounds.bottom = bitmap.getHeight();
    }

    doSomething();
}