public boolean removeItem(int position) {
    if(position >= items.size()) return false;
    Iterator<?> it=items.values().iterator();
    for(int counter = 0; counter < position; counter++) it.next();
    boolean result = it.next() != null;
    it.remove();
    return result;
}