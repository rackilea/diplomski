public boolean updateOutline(List<HashMap<String, Object>> outlines, HashMap<String, Object> entry, int p) {
    int index = 0;
    for (HashMap<String, Object> outline : outlines) {
        Object kids = outline.get("Kids");
        if (kids != null) {
            updateOutline((List<HashMap<String, Object>>)kids, entry, p);
        }
        else {
            if (p < getPage(outline)) {
                outlines.add(index, entry);
                return true;
            }
            index++;
        }
    }
    return false;
}

public int getPage(HashMap<String, Object> outline) {
    Object page = outline.get("Page");
    if (page == null) return -1;
    String p = page.toString().substring(0, page.toString().indexOf(" "));
    return Integer.parseInt(p);
}