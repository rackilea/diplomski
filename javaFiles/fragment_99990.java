public int find(String line, int startPosition) {
    if (doc[startPosition].contains(line) {
        return startPosition;
    }
    for (int i = 0; i < Math.max(doc.size() - startPosition, startPosition); i++) {
        if (startPosition - i > 0 && doc[startPosition - i].contains(line)) {
            return startPosition - i;
        }
        if (startPosition + i < doc.size() && doc[startPosition + i].contains(line)) {
            return startPosition + i;
        }

    }
    return -1;
}