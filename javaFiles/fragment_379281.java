int maxWidth = -1;
int maxHeight = -1;
ImageView iv = (ImageView) findViewById(R.id.imageview);

try {
     Field maxWidthField = ImageView.class.getDeclaredField("mMaxWidth");
     Field maxHeightField = ImageView.class.getDeclaredField("mMaxHeight");
     maxWidthField.setAccessible(true);
     maxHeightField.setAccessible(true);

     maxWidth = (Integer) maxWidthField.get(iv);
     maxHeight = (Integer) maxHeightField.get(iv);
} catch (SecurityException e) {
    e.printStackTrace();
} catch (NoSuchFieldException e) {
    e.printStackTrace();
} catch (IllegalArgumentException e) {
    e.printStackTrace();
} catch (IllegalAccessException e) {
    e.printStackTrace();
}