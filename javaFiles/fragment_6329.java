for (int i = 0; i < entryDirectory.length; i++) {
    if (findEntries(name).length != 0) {
        if (entryDirectory[i].equals(findEntries(name)[0])) {
            entryDirectory[i] = null;// this is the source of exception
        }
    }
}