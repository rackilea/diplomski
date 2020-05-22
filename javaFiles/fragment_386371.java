private void methodName(String className) {
    Class myClass = Class.forName(className);
    Object obj;
    /* Complicated code to find obj in datastructure */
    if (myClass.isInstance(obj)) {
        /* Do stuff */
    }
}