Set<Integer> selectedSet = new HashSet<>();
// I will assume you have some kind of call back to tell you the user selected one or unselected (Since your question is missing how you get this info)
private void selectThought(Integer thoughtKey) {
    selectedSet.add(thoughtKey);
}

private void unselectThought(Integer thoughtKey) {
    selectedSet.remove(thoughtKey);
}