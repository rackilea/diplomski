@Override public void show()
{       
    Point mouseLocation = MouseInfo.getPointerInfo().getLocation();

    setX(mouseLocation.getX());
    setY(mouseLocation.getY());

    super.show();
}