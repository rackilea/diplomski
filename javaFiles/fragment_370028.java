public class MyView extends View {
  private Face[] foundFaces;

  public MyView(Context context, AttributeSet attrs, int defStyle) {
    super(context, attrs, defStyle);
  }

  public MyView(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  public MyView(Context context) {
    super(context);
  }

  public void computeFaces() {
  //In here, do the Face finding processing, and store the found Faces in the foundFaces variable.
    if (numberOfFaces> 0) {
      this.invalidate();
    }
  }

  @Override
  protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);
    if ((foundFaces != null) && (foundFaces.length > 0)) {
        for (Face f : foundFaces) {
            canvas.drawBitmap(
              //your square bitmap,
              //x position of the face,
              //y position of the face,
              //your define paint);
        }
    }
  }
}