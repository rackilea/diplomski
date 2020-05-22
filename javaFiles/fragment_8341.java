if (mavContainer.containsAttribute(name)) {
    attribute = mavContainer.getModel().get(name);
} else {
    // Create attribute instance
    try {
        attribute = createAttribute(name, parameter, binderFactory, webRequest);
    }
    catch (BindException ex) {
        ...
    }
}
...
mavContainer.addAllAttributes(attribute);