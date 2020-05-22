@Override
public int getGroupCount() {
    return this.constantList.size();
}

@Override
public int getChildrenCount(int groupPosition) {
    return 1; // Looks like you have only one child in each group, change this if not
}