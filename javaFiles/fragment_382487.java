@Override
public void setLocation(int x, int y) {
    super.setLocation(x-(size/2), y-(size/2));
}
@Override
public void setLocation(Point p) {
    super.setLocation((int)p.getX()-size/2,(int)p.getY()-size/2);
}