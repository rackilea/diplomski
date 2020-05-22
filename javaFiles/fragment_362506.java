layout.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
public void onGlobalLayout() {
    getViewTreeObserver().removeGlobalOnLayoutListener(this);

    int[] locations = new int[2];
     layout.getLocationOnScreen(locations);
    int x = locations[0];
    int y = locations[1];
}
});