import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

public class Car extends View {
    private final Paint mBlackPaint = new Paint();
    private final Paint mRedPaint = new Paint();
    private final TextPaint mTextPaint;

    public static final int BOXES_COUNT = 8;

    private float oneDp;
    private float textSize;
    private float windowHeight;

    public Car(Context context, AttributeSet attrs) {
        super(context, attrs);
        oneDp = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 1,
            getResources().getDisplayMetrics());
        windowHeight = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 10,
            getResources().getDisplayMetrics());
        textSize = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 15,
            getResources().getDisplayMetrics());

        mRedPaint.setColor(Color.parseColor("#CC3333"));

        mBlackPaint.setAntiAlias(true);
        mBlackPaint.setColor(Color.BLACK);
        mBlackPaint.setStrokeWidth(oneDp);
        mBlackPaint.setStyle(Paint.Style.STROKE);

        mTextPaint = new TextPaint(TextPaint.ANTI_ALIAS_FLAG);
        mTextPaint.setColor(Color.BLACK);
        mTextPaint.setTextAlign(Paint.Align.CENTER);
        mTextPaint.setTextSize(textSize);

        mWindowPaint = new Paint();
        mWindowPaint.setAntiAlias(true);
        mWindowPaint.setColor(Color.parseColor("#CC3333"));
        mWindowPaint.setStyle(Paint.Style.STROKE);
        mWindowPaint.setStrokeWidth(oneDp);
    }

    private Paint mWindowPaint;
    RectF rect = new RectF();
    RectF rect2 = new RectF();

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (getWidth() == 0) return;

        int w = canvas.getWidth();
        int h = canvas.getHeight();

        //draw red rectangles
        float mSideRectWidth = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 5,
            getResources().getDisplayMetrics());
        canvas.drawRect(0, 0, mSideRectWidth, getHeight(), mRedPaint); //draw left end rectangle
        canvas.drawRect(getWidth() - mSideRectWidth, 0, getWidth(), getHeight(),
            mRedPaint); //draw right end rectangle

        //draw grey boxes
        setBackgroundColor(Color.parseColor("#808080"));

        for (int i = 0; i < BOXES_COUNT; i++) {
            float leftPosition = mSideRectWidth
                + i * oneDp
                + (getWidth() - mSideRectWidth * 2 - (BOXES_COUNT - 1) * oneDp) * i / BOXES_COUNT;
            float rightPosition = mSideRectWidth
                + i * oneDp
                + (getWidth() - mSideRectWidth * 2 - (BOXES_COUNT - 1) * oneDp) * (i + 1)
                / BOXES_COUNT;
            if (i == 0) {
                fillRectLeft(canvas, leftPosition, rightPosition, (i + 1) + "");
            } else if ( i == BOXES_COUNT - 1) {
                fillRectRight(canvas, leftPosition, rightPosition, (i + 1) + "");
            } else {
                fillRect(canvas, leftPosition, rightPosition, (i + 1) + "");
            }
        }

        //draw black lines
        for (int i = 1; i < BOXES_COUNT; i++) {
            float position = mSideRectWidth + (getWidth() - mSideRectWidth * 2) * i / BOXES_COUNT;
            canvas.drawLine(position, 0, position, getHeight(), mBlackPaint);
        }
    }

    private void fillRect(Canvas canvas, float left, float right, String number) {
        rect.set(left + oneDp / 2, 0 + oneDp / 2, right - oneDp / 2, getHeight() - oneDp / 2);
        float xPos = left + ((right - left) / 2);
        float yPos = (canvas.getHeight() / 2) - ((mTextPaint.descent() + mTextPaint.ascent()) / 2);
        //((textPaint.descent() + textPaint.ascent()) / 2) is the distance from the baseline to the center.
        canvas.drawText(number, xPos, yPos, mTextPaint);
        //canvas.drawRect(rect, mWindowPaint);

        // top row
        rect2.set(left + oneDp / 2, 0 + oneDp / 2, left + (right - left) * 20 / 100 - oneDp / 2,
            windowHeight - oneDp / 2);
        canvas.drawRect(rect2, mWindowPaint);
        rect2.set(left + (right - left) * 27 / 100 + oneDp / 2, 0 + oneDp / 2,
            left + (right - left) * 47 / 100 - oneDp / 2, windowHeight - oneDp / 2);
        canvas.drawRect(rect2, mWindowPaint);
        rect2.set(left + (right - left) * 53 / 100 + oneDp / 2, 0 + oneDp / 2,
            left + (right - left) * 73 / 100 - oneDp / 2, windowHeight - oneDp / 2);
        canvas.drawRect(rect2, mWindowPaint);
        rect2.set(left + (right - left) * 80 / 100 + oneDp / 2, 0 + oneDp / 2,
            left + (right - left) * 100 / 100 - oneDp / 2, windowHeight - oneDp / 2);
        canvas.drawRect(rect2, mWindowPaint);

        // bottom row
        rect2.set(left + oneDp / 2, getHeight() - windowHeight + oneDp / 2,
            left + (right - left) * 20 / 100 - oneDp / 2, getHeight() - oneDp / 2);
        canvas.drawRect(rect2, mWindowPaint);
        rect2.set(left + (right - left) * 27 / 100 + oneDp / 2,
            getHeight() - windowHeight + oneDp / 2, left + (right - left) * 47 / 100 - oneDp / 2,
            getHeight() - oneDp / 2);
        canvas.drawRect(rect2, mWindowPaint);
        rect2.set(left + (right - left) * 53 / 100 + oneDp / 2,
            getHeight() - windowHeight + oneDp / 2, left + (right - left) * 73 / 100 - oneDp / 2,
            getHeight() - oneDp / 2);
        canvas.drawRect(rect2, mWindowPaint);
        rect2.set(left + (right - left) * 80 / 100 + oneDp / 2,
            getHeight() - windowHeight + oneDp / 2, left + (right - left) * 100 / 100 - oneDp / 2,
            getHeight() - oneDp / 2);
        canvas.drawRect(rect2, mWindowPaint);
    }

    private void fillRectLeft(Canvas canvas, float left, float right, String number) {
        rect.set(left + oneDp / 2, 0 + oneDp / 2, right - oneDp / 2, getHeight() - oneDp / 2);
        float xPos = left + ((right - left) / 2);
        float yPos = (canvas.getHeight() / 2) - ((mTextPaint.descent() + mTextPaint.ascent()) / 2);
        //((textPaint.descent() + textPaint.ascent()) / 2) is the distance from the baseline to the center.
        canvas.drawText(number, xPos, yPos, mTextPaint);
        //canvas.drawRect(rect, mWindowPaint);

        // top row
        rect2.set(left + (right - left) * 4 / 100 + oneDp / 2, 0 + oneDp / 2,
            left + (right - left) * 24 / 100 - oneDp / 2, windowHeight - oneDp / 2);
        canvas.drawRect(rect2, mWindowPaint);
        rect2.set(left + (right - left) * 42 / 100 + oneDp / 2, 0 + oneDp / 2,
            left + (right - left) * 62 / 100 - oneDp / 2, windowHeight - oneDp / 2);
        canvas.drawRect(rect2, mWindowPaint);
        rect2.set(left + (right - left) * 80 / 100 + oneDp / 2, 0 + oneDp / 2,
            left + (right - left) * 100 / 100 - oneDp / 2, windowHeight - oneDp / 2);
        canvas.drawRect(rect2, mWindowPaint);

        // bottom row
        rect2.set(left + (right - left) * 4 / 100 + oneDp / 2,
            getHeight() - windowHeight + oneDp / 2, left + (right - left) * 24 / 100 - oneDp / 2,
            getHeight() - oneDp / 2);
        canvas.drawRect(rect2, mWindowPaint);
        rect2.set(left + (right - left) * 42 / 100 + oneDp / 2,
            getHeight() - windowHeight + oneDp / 2, left + (right - left) * 62 / 100 - oneDp / 2,
            getHeight() - oneDp / 2);
        canvas.drawRect(rect2, mWindowPaint);
        rect2.set(left + (right - left) * 80 / 100 + oneDp / 2,
            getHeight() - windowHeight + oneDp / 2, left + (right - left) * 100 / 100 - oneDp / 2,
            getHeight() - oneDp / 2);
        canvas.drawRect(rect2, mWindowPaint);
    }

    private void fillRectRight(Canvas canvas, float left, float right, String number) {
        rect.set(left + oneDp / 2, 0 + oneDp / 2, right - oneDp / 2, getHeight() - oneDp / 2);
        float xPos = left + ((right - left) / 2);
        float yPos = (canvas.getHeight() / 2) - ((mTextPaint.descent() + mTextPaint.ascent()) / 2);
        //((textPaint.descent() + textPaint.ascent()) / 2) is the distance from the baseline to the center.
        canvas.drawText(number, xPos, yPos, mTextPaint);
        //canvas.drawRect(rect, mWindowPaint);

        // top row
        rect2.set(left + (right - left) * 0 / 105 + oneDp / 2, 0 + oneDp / 2,
            left + (right - left) * 20 / 105 - oneDp / 2, windowHeight - oneDp / 2);
        canvas.drawRect(rect2, mWindowPaint);
        rect2.set(left + (right - left) * 38 / 105 + oneDp / 2, 0 + oneDp / 2,
            left + (right - left) * 58 / 105 - oneDp / 2, windowHeight - oneDp / 2);
        canvas.drawRect(rect2, mWindowPaint);
        rect2.set(left + (right - left) * 78 / 105 + oneDp / 2, 0 + oneDp / 2,
            left + (right - left) * 98 / 105 - oneDp / 2, windowHeight - oneDp / 2);
        canvas.drawRect(rect2, mWindowPaint);

        // bottom row
        rect2.set(left + (right - left) * 0 / 105 + oneDp / 2,
            getHeight() - windowHeight + oneDp / 2, left + (right - left) * 20 / 105 - oneDp / 2,
            getHeight() - oneDp / 2);
        canvas.drawRect(rect2, mWindowPaint);
        rect2.set(left + (right - left) * 38 / 105 + oneDp / 2,
            getHeight() - windowHeight + oneDp / 2, left + (right - left) * 58 / 105 - oneDp / 2,
            getHeight() - oneDp / 2);
        canvas.drawRect(rect2, mWindowPaint);
        rect2.set(left + (right - left) * 78 / 105 + oneDp / 2,
            getHeight() - windowHeight + oneDp / 2, left + (right - left) * 98 / 105 - oneDp / 2,
            getHeight() - oneDp / 2);
        canvas.drawRect(rect2, mWindowPaint);
    }
}