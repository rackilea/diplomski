public boolean list(int list_view) {
    if(list.size() >= list_view && list_view > 0) {
        list.get(list_view - 1).click();
        return true;
    }
    return false;
}