//Assign an id for the next marked content element.
private void setNextMarkedContentDictionary(String tag) {
    currentMarkedContentDictionary = new COSDictionary();
    currentMarkedContentDictionary.setName("Tag", tag);
    currentMarkedContentDictionary.setInt(COSName.MCID, currentMCID);
    currentMCID++;
}