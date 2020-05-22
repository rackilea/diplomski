for(String s : lines ) {
    // if 0 is the smallest x coordinates
    int x = random(0, maxWidth);
    int y = random(0, maxHeight);
    ItemObject item = new ItemObject();
    item.setItem(s)
    item.setX(x);
    item.setY(y);
    mLoot.add(item);
}