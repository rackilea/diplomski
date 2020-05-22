public static <T extends Serializable> T getAttr(String name, HttpSession sess) {
    @SuppressWarnings("unchecked")
    AttrWrapper<T> attr = (AttrWrapper<T>) sess.getAttribute("myattr");
    if (attr == null)
        return null;
    if (attr.isValid())
        return attr.value; // Attribute is valid, you can use it

    // Attribute is invalid, timed out, remove it
    sess.removeAttribute("myattr");
    return null;
}