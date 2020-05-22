class BitmapButtonField extends ButtonField {
 protected DropdownItem mItem;
 boolean mTextItem;
 int mWidth;
 int mHeight;

 public BitmapButtonField(DropdownItem item, boolean textItem) {
  super(CONSUME_CLICK);
  mItem = item;
  mTextItem = textItem;
  mWidth = mItem.mBitmap.getWidth() + 6
    + (mTextItem ? getFont().getAdvance(mItem.mName) + 6 : 0);
  mHeight = mItem.mBitmap.getHeight() + 6;
  setMargin(0, 0, 0, 0);
  setPadding(0, 0, 0, 0);
  setBorder(BorderFactory.createSimpleBorder(new XYEdges(0, 0, 0, 0)));
  setBorder(VISUAL_STATE_ACTIVE, BorderFactory
    .createSimpleBorder(new XYEdges(0, 0, 0, 0)));
 }

 protected void paint(Graphics graphics) {
  int color = (getVisualState() == VISUAL_STATE_FOCUS) ? Color.LIGHTGREY
    : Color.DARKGRAY;
  graphics.setColor(color);
  graphics.drawRect(1, 1, mWidth - 2, mHeight - 2);
  graphics.drawBitmap(3, 3, mItem.mBitmap.getWidth(), mItem.mBitmap
    .getHeight(), mItem.mBitmap, 0, 0);
  if (mTextItem)
   graphics.drawText(mItem.mName, mItem.mBitmap.getWidth() + 6, 3);

 }

 public int getPreferredWidth() {
  return mWidth;
 }

 public int getPreferredHeight() {
  return mHeight;
 }

 protected void layout(int width, int height) {
  setExtent(mWidth, mHeight);
 }
}