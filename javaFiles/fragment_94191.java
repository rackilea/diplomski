class Scr extends MainScreen {
 DDImagesButton ddImages1;
 DDImagesButton ddImages2;

 public Scr() {
  HorizontalFieldManager hfm = new HorizontalFieldManager();
  add(hfm);

  DropdownItem[] items = new DropdownItem[6];
  items[0] = new DropdownItem(Bitmap.getBitmapResource("1.png"),
    "Add Item");
  items[1] = new DropdownItem(Bitmap.getBitmapResource("2.png"),
    "Attachment");
  items[2] = new DropdownItem(Bitmap.getBitmapResource("3.png"), "Time");
  items[3] = new DropdownItem(Bitmap.getBitmapResource("4.png"), "User");
  items[4] = new DropdownItem(Bitmap.getBitmapResource("5.png"), "Group");
  items[5] = new DropdownItem(Bitmap.getBitmapResource("6.png"),
    "Information");
  ddImages1 = new DDImagesButton(items);
  hfm.add(ddImages1);

  ddImages2 = new DDImagesButton(items);
  hfm.add(ddImages2);
 }
}