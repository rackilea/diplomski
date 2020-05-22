public class MaxHeightNestedScrollView extends NestedScrollView {

private int maxHeight = -1;

public MaxHeightNestedScrollView(@NonNull Context context) {
    this(context, null, 0); // Modified changes
}

public MaxHeightNestedScrollView(@NonNull Context context, @Nullable AttributeSet attrs) {
    this(context, attrs, 0); // Modified changes
}

public MaxHeightNestedScrollView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    init(context, attrs, defStyleAttr); // Modified changes
}

 // Modified changes
private void init(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr){
    final TypedArray a = context.obtainStyledAttributes(
            attrs, R.styleable.MaxHeightNestedScrollView, defStyleAttr, 0);
    maxHeight = 
    a.getDimensionPixelSize(R.styleable.MaxHeightNestedScrollView_maxHeight, 0);
    a.recycle();
}

public int getMaxHeight() {
    return maxHeight;
}

public void setMaxHeight(int maxHeight) {
    this.maxHeight = maxHeight;
}

@Override
protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
    if (maxHeight > 0) {
        heightMeasureSpec = MeasureSpec.makeMeasureSpec(maxHeight, MeasureSpec.AT_MOST);
    }
    super.onMeasure(widthMeasureSpec, heightMeasureSpec);
}
}