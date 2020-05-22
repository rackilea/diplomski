public class FifthWidthView extends FrameLayout {
  public FifthWidthView(Context context) {
    super(context);
  }

  public FifthWidthView(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  public FifthWidthView(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
  }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
      int availableHeight = MeasureSpec.getSize(heightMeasureSpec);
      int wantedWidth = availableHeight / 5;

      setMeasuredDimension(wantedWidth, availableHeight);
    }
}