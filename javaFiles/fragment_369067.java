public boolean find() {
    int nextSearchIndex = last;
    if (nextSearchIndex == first)
        nextSearchIndex++;

    // If next search starts before region, start it at region
    if (nextSearchIndex < from)
        nextSearchIndex = from;

    // If next search starts beyond region then it fails
    if (nextSearchIndex > to) {
        for (int i = 0; i < groups.length; i++)
            groups[i] = -1;
        return false;
    }
    return search(nextSearchIndex);
}