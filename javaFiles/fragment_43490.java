String iconName(int icon) {
    return getResources().getResourceEntryName(icon);
}

int iconRes(String icon) {
    return getResources().getIdentifier(icon, "drawable", mContext.getPackageName())
}