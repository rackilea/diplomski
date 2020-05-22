public class RotatedTextView extends AppCompatTextView {
private int mRotationAngle = 90;


@Override
protected void onDraw(Canvas canvas) {
    if (mRotationAngle == 90) {
        canvas.rotate(mRotationAngle);
        canvas.translate(0, -getWidth());
    } else if (mRotationAngle == -90) {
        canvas.rotate(mRotationAngle);
        canvas.translate(-getHeight(), 0);
    }
    super.onDraw(canvas);
} 
}