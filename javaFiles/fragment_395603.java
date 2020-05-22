try {
    DesiredClass.class.getMethod("desiredMethod", <parameter types...>)
    // Do 1.6 things
}
catch (NoSuchMethodException e) {
    // Do 1.5 things
}