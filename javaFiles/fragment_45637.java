private boolean isTokenedServerResource() {
    if (getNext() instanceof CustomFinder) {
        CustomFinder finder = (CustomFinder) getNext();
        if (MyServerResource1.class.isAssignableFrom(finder.getTargetClass())) {
            return true;
        }
    }
    return false;
}