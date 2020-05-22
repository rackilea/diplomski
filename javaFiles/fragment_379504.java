boolean doesImplementInterface(Object classToTest, Class<?> interfaceToTestAgainst) {
    if (!interfaceToTestAgainst.isInterface()) {
        return false;
    }
    return interfaceToTestAgainst.isInstance(classToTest);
}