private PDRectangle getFieldArea(PDField field) {
  COSDictionary fieldDict = field.getDictionary();
  COSArray fieldAreaArray = (COSArray) fieldDict.getDictionaryObject(COSName.RECT);
  PDRectangle result = new PDRectangle(fieldAreaArray);
  return result;
}