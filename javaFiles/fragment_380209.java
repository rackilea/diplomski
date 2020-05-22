import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;

// Use this class with a Canvas to create the effect you want.
public class CurvedBitmapDrawer
{
    private Context mContext;
    private Paint mPaint;
    private int mResourceId;
    private Bitmap mBitmap;
    private Path mPath;
    private int mBitmapMargin;

    // Create with a context so that this class can use resource ids.
    public CurvedBitmapDrawer(Context context) {
        mContext = context;
        mPath = new Path();
    }

    // getters setters for paint.
    // this paint will be used to draw the bitmaps, and the strokeWidth value in the paint
    // will be used to set the thickness of the curve / line that is drawn.
    public Paint getPaint() {
        return mPaint;
    }

    public void setPaint(Paint paint) {
        mPaint = paint;
    }

    // getters setters for the space between the bitmaps.
    public int getBitmapMargin()
    {
        return mBitmapMargin;
    }

    public void setBitmapMargin(int bitmapMargin)
    {
        mBitmapMargin = bitmapMargin;
    }

    // getters setters for res id
    public int getResourceId() {
        return mResourceId;
    }

    public void setResourceId(int resourceId)
    {
        mResourceId = resourceId;
        mBitmap = null;
    }

    // alternative optional getters setters for bitmap.
    public Bitmap getBitmap()
    {
        return mBitmap;
    }

    public void setBitmap(Bitmap bitmap)
    {
        mBitmap = bitmap;
        mResourceId = 0;
    }

    // I decided to only use a local path here, but feel free to change it.
    // call getPath to perform actions on the path that is drawn by this class.
    public Path getPath()
    {
        return mPath;
    }

    // draw method. comments inline.
    public void draw(Canvas canvas)
    {
        // grab a bitmap in the desired size.
        final Bitmap scaledBitmap = getScaledBitmap();

        // find the center of the bitmap.
        final float centerX = scaledBitmap.getWidth() / 2;
        final float centerY = scaledBitmap.getHeight() / 2;

        // wrap the path with a measurement tool for paths - PathMeasure
        final PathMeasure pathMeasure = new PathMeasure(mPath, false);

        // initialize the distance to the center of the bitmap.
        float distance = scaledBitmap.getWidth() / 2;

        // initialize position and slope buffers.
        float[] position = new float[2];
        float[] slope = new float[2];

        float slopeDegree;

        // draw so long as the distance traveled on the path isn't longer than
        // the total distance of the path.
        while (distance < pathMeasure.getLength())
        {
            // grab the position & slope (tangent) on a particular distance along the path.
            pathMeasure.getPosTan(distance, position, slope);

            // convert the vector to a degree.
            slopeDegree = (float)((Math.atan2(slope[1], slope[0]) * 180f) / Math.PI);

            // preserve the current state of the canvas
            canvas.save();

            // translate the canvas to the position on the path.
            canvas.translate(position[0] - centerX, position[1] - centerY);

            // rotate the canvas around the center of the bitmap the amount of degrees needed.
            canvas.rotate(slopeDegree, centerX, centerY);

            // draw the bitmap
            canvas.drawBitmap(scaledBitmap, 0, 0, mPaint);

            // revert the bitmap to the previous state
            canvas.restore();

            // increase the distance by the bitmap's width + the desired margin.
            distance += scaledBitmap.getWidth() + mBitmapMargin;
        }

    }

    // returns a scaled bitmap from the asset specified.
    private Bitmap getScaledBitmap()
    {
        // no bitmap or resId, return null (no special handing of this! add if you like).
        if (mBitmap == null && mResourceId == 0)
            return null;

        // if no bitmap is specified, create one from the resource id. 
        // Optimization: be sure to clear the bitmap once done.
        if (mBitmap == null)
            mBitmap = BitmapFactory.decodeResource(mContext.getResources(), mResourceId);

        // width / height of the bitmap[
        float width = mBitmap.getWidth();
        float height = mBitmap.getHeight();

        // ratio of the bitmap
        float ratio = width / height;

        // set the height of the bitmap to the width of the path (from the paint object).
        float scaledHeight = mPaint.getStrokeWidth();

        // to maintain aspect ratio of the bitmap, use the height * ratio for the width.
        float scaledWidth = scaledHeight * ratio;

        // return the generated bitmap, scaled to the correct size.
        return Bitmap.createScaledBitmap(mBitmap, (int)scaledWidth, (int)scaledHeight, true);
    }
}