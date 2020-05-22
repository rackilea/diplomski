private boolean inViewBounds(View view, int x, int y){
    view.getDrawingRect(outRect);
    view.getLocationOnScreen(location);
    outRect.offset(location[0], location[1]);
    return outRect.contains(x, y);
}