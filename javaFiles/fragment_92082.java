/**
* create new contact filter for ALL LIGHTS with give parameters
*/
static public void setContactFilter(short categoryBits, short groupIndex,
            short maskBits) {
    filterA = new Filter();
    filterA.categoryBits = categoryBits;
    filterA.groupIndex = groupIndex;
    filterA.maskBits = maskBits;
}