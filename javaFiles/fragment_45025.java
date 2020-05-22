AttrWrapper<?> attr = (AttrWrapper<?>) session.getAttribute("myattr");
if (attr != null) {
    if (attr.isValid()) {
        // Attribute is valid, you can use it
    } 
    else {
        // Attribute is invalid, timed out, remove it
        session.removeAttribute("myattr");
    }
}