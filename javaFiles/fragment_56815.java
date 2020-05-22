public void testMethod() {
    if (isDetached() && getParentFragment() != null) {
        return;
    }

    ...
}