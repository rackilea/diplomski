public boolean removeItem(int position) {
    if(position >= items.size()) return false;
    Iterator<?> it=items.entrySet().iterator();
    for(int counter = 0; counter <= position; counter++) it.next();
    it.remove();
    return true;
}