/**
 * Overloaded to make variables appear as bean properties or via the subscript operator
 */
public Object getProperty(String property) {
    /** @todo we should check if we have the property with the metaClass instead of try/catch  */
    try {
        return super.getProperty(property);
    }
    catch (MissingPropertyException e) {
        return getVariable(property);
    }
}

/**
 * Overloaded to make variables appear as bean properties or via the subscript operator
 */
public void setProperty(String property, Object newValue) {
    /** @todo we should check if we have the property with the metaClass instead of try/catch  */
    try {
        super.setProperty(property, newValue);
    }
    catch (MissingPropertyException e) {
        setVariable(property, newValue);
    }
}