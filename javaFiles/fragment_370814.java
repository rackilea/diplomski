private boolean equals(Set elements, Set elements2) {
    return elements != null && elements.equals(elements2);
}

private List<Set> removeDuplicates(List<Set> from) {
    List<Set> noDuplicates = new ArrayList<Set>();

    for (Set possibleDuplicate : from) {
        boolean alreadyInNoDuplicatesList = false;
        for (Set elementFromNoDuplicateList : noDuplicates) {
            if (equals(elementFromNoDuplicateList, possibleDuplicate)) {
                alreadyInNoDuplicatesList = true;
                break;
            }
        }
        if (!alreadyInNoDuplicatesList) {
            noDuplicates.add(possibleDuplicate);
        }
    }

    return noDuplicates;
}