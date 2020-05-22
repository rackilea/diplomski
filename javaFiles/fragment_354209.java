public static Boolean CtabExists(CTabFolder folder, CTabItem tab) {
    if (tab != null) {
        int intIndex = -1;
        intIndex = folder.indexOf(tab);
        if (intIndex == -1) {
            return false;
        } else {
            return true;
        }
    } else {
        return false;
    }
}