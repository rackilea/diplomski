class DDImagesButton extends BitmapButtonField implements FieldChangeListener {
 DropdownItem[] mItems;
 int mIndex;

 public DDImagesButton(DropdownItem[] items) {
  super(items[0], false);
  mItems = items;
  updateIndex(0);
  setChangeListener(this);
 }

 protected void paint(Graphics graphics) {
  super.paint(graphics);

  int x = mItems[mIndex].mBitmap.getWidth() + 2;
  int y = 5;

  int y1 = y;
  int y2 = y + 10;
  int x1 = x;
  int x2 = x + 18;
  int[] xPts = new int[] { x1, x2, x1 + 9 };
  int[] yPts = new int[] { y1, y1, y2 };
  graphics.drawFilledPath(xPts, yPts, null, null);
 }

 public void fieldChanged(Field field, int context) {
  getScreen().getUiEngine().pushScreen(new DDImagesPopUp());
 }

 public void updateIndex(int index) {
  mIndex = index;
  mItem = mItems[mIndex];
  mWidth = mItem.mBitmap.getWidth() + 6 + 18 + 3;
  mHeight = mItem.mBitmap.getHeight() + 6;
  invalidate();
 }

 class DDImagesPopUp extends PopupScreen implements FieldChangeListener {

  public DDImagesPopUp() {
   super(
     new VerticalFieldManager(VERTICAL_SCROLL
       | VERTICAL_SCROLLBAR));
   for (int i = 0; i < mItems.length; i++) {
    BitmapButtonField button = new BitmapButtonField(mItems[i],
      true);
    add(button);
    button.setChangeListener(this);
   }
   setFieldWithFocus(getField(mIndex));
  }

protected boolean keyChar(char key, int status, int time) {
    if (Keypad.KEY_ESCAPE == key) {
        this.close();
        return true;
    } else
        return super.keyChar(key, status, time);
}

  public void fieldChanged(Field field, int context) {
   updateIndex(getFieldWithFocusIndex());
   close();
  }
 }
}