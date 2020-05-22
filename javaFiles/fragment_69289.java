TypedArray menuResources = getResources().obtainTypedArray(R.array.menu_items);

TypedArray itemDef;

for (int i = 0; i < menuResources.length(); i++) {
    int resId = menuResources.getResourceId(i, -1);
    if (resId < 0) {
        continue;
    }

    itemDef = getResources().obtainTypedArray(resId);
    //itemDef.getDrawable(0)
    //itemDef.getString(1)
    //itemDef.getString(2)
}