layout.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
    @Override
    public void onGlobalLayout() {
        width = layout.getWidth();
        height = layout.getHeight();

        // move here
        widthtext.setText(width);
        heighttext.setText(height);
    }
});
}