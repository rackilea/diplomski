/**
 * Set an attribute on this object.
 *
 * @param name  the name of the attribute to change
 * @param value the new value of the attribute
 * @return true if the attribute value was added or changed, otherwise false
 */
public boolean setAttribute(String name, Object value) {
    if (name != null) {
        if (value != null) {
            // update with new value
            Object previous = attributes.put(name, value);
            // previous will be null if the attribute didn't exist
            return (previous == null || !value.equals(previous));
        }
    }
    return false;
}