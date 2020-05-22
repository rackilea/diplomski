private PDRectangle getFieldArea(PDField field) {
  COSDictionary fieldDict = field.getDictionary();
  COSArray fieldAreaArray = (COSArray) fieldDict.getDictionaryObject(COSName.RECT);

  float left = (float) ((COSFloat) fieldAreaArray.get(0)).doubleValue();
  float bottom = (float) ((COSFloat) fieldAreaArray.get(1)).doubleValue();
  float right = (float) ((COSFloat) fieldAreaArray.get(2)).doubleValue();
  float top = (float) ((COSFloat) fieldAreaArray.get(3)).doubleValue();

  return new PDRectangle(new BoundingBox(left, bottom, right, top));
}