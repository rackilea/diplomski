private  <T extends Shape & Fillable> void setFilledAndAdd(T obj, Color color, int x, int y){
    obj.setFilled(true);    // needs interface Fillable
    obj.setFillColor(color);
    add(obj, x, y);
}

private void add(Shape s, int x, int y){
    // whatever code you have goes here.
}