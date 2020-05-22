ImageView iv = (ImageView)findViewById(R.id.imageview);
int scaledHeight, scaledWidth;
iv.getViewTreeObserver().addOnPreDrawListener(
    new ViewTreeObserver.OnPreDrawListener() {
    @Override
    public boolean onPreDraw() {
        Rect rect = iv.getDrawable().getBounds();
        scaledHeight = rect.height();
        scaledWidth = rect.width();
        iv.getViewTreeObserver().removeOnPreDrawListener(this);
        return true;
    }
});