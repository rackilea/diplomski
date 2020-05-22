for (Entry x : entries) {
    if (x.equals(entryIn)) {
        return entries.indexOf(x); // if you find it, return the index.
    }
}

return -1; // if you didn't return already, you didn't find it. so return -1