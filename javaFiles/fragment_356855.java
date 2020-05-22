while (index < entries.size() && !found) {
    if (entries.get(index).equals(entryIn)) {
        found = true;
    } else {
        index++;
    }
    if (index == entries.size()) {
        index = -1;
    }
    return index;
}