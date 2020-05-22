private Map<String, FontType> getMapFromTags(String toCheck) {
    Map<String, FontType> chunksMap = new LinkedHashMap<>();
    boolean openTag = false;

    while (toCheck.contains(TAG_NEGRITA) || toCheck.contains(TAG_CURSIVA)) {
        final int indexOfBold = toCheck.indexOf(TAG_NEGRITA);
        final int indexOfItalics = toCheck.indexOf(TAG_CURSIVA);

        final int indexToUse = getValidIndexToUse(indexOfBold, indexOfItalics);

        final String substring = toCheck.substring(0, indexToUse);
        toCheck = toCheck.substring(indexToUse + 3, toCheck.length());

        if (!substring.isEmpty()) {
            if (!openTag) {
                chunksMap.put(substring, FontType.NORMAL);
            } else if (indexToUse == indexOfBold) {
                chunksMap.put(substring, FontType.BOLD);
            } else {
                chunksMap.put(substring, FontType.ITALIC);
            }
        }

        openTag = !openTag;
    }
    // check if there is some NORMAL text at the end
    if (!toCheck.isEmpty())
        chunksMap.put(toCheck, FontType.NORMAL);

    return chunksMap;
}

private int getValidIndexToUse(int indexOfBold, int indexOfItalics) {
    if (indexOfBold > -1 && indexOfItalics == -1)
        return indexOfBold;
    else if (indexOfItalics > -1 && indexOfBold == -1)
        return indexOfItalics;
    else 
        return indexOfBold > -1 && indexOfBold < indexOfItalics ? indexOfBold : indexOfItalics;
}