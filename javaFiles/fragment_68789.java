@Override
public int getChildrenCount(int groupPosition) {
    try {
        return this._listDataChild.get(this._listDataHeader.get(groupPosition))
                .size();
    } catch (NullPointerException e) {
        e.printStackTrace();
        return 0;
    }
}