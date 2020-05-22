private Entry[] findEntries(String name) {

    Entry[] returnEntries = new Entry[0];

    for (int i = 0; i < entryDirectory.length; i++) {

        if (entryDirectory[i] != null) {

            if ((entryDirectory[i].getSurname() + " " + entryDirectory[i]
                    .getInitials()).equalsIgnoreCase(name)) {

                returnEntries = Arrays.copyOf(returnEntries,
                        returnEntries.length + 1);
                returnEntries[returnEntries.length - 1] = entryDirectory[i];
            }
        }
    }
    return returnEntries;
}