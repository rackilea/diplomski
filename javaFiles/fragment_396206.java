final View makebig = findViewById(R.id.makebig);
final View scrollview = findViewById(R.id.scrollview);

final ViewTreeObserver viewTreeObserver = scrollview.getViewTreeObserver();
viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
    @Override
    public void onGlobalLayout() {
        //only do this all once
        scrollview.getViewTreeObserver().removeOnGlobalLayoutListener(this);

        makebig.getLayoutParams().height = scrollview.getHeight();
    }
});