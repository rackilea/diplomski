private enum PropertyKeys {
    currentPageNumber;
}

public void setCurrentPageNumber(int currentPageNumber) {
    getStateHelper().put(PropertyKeys.currentPageNumber, currentPageNumber);
}

public int getCurrentPageNumber() {
    return (int) getStateHelper().eval(PropertyKeys.currentPageNumber, 0);
}