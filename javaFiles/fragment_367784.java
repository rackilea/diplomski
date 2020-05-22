@Override
public void run()
{
    while(running)
    {
        if(!holder.getSurface().isValid())
        {
            continue;
        }

        startTime = System.currentTimeMillis();

        cloudMovement();

        canvas = holder.lockCanvas();
        canvas.drawBitmap(bg, 0, 0, null);
        canvas.drawBitmap(sun, 20, 20, null);

        canvas.drawBitmap(cloud1, c1x, c1y, null);
        canvas.drawBitmap(cloud2, c2x, c2y, null);
        canvas.drawBitmap(cloud3, c3x, c3y, null);

        holder.unlockCanvasAndPost(canvas);

        doFpsCheck(startTime);
    }

}