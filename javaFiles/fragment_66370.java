/**
 * Returns the value mapped by {@code name} if it exists, coercing it if
 * necessary, or throws if no such mapping exists.
 *
 * @throws JSONException if no such mapping exists.
 */
public String getString(String name) throws JSONException {
    Object object = get(name);
    String result = JSON.toString(object);
    if (result == null) {
        throw JSON.typeMismatch(name, object, "String");
    }
    return result;
}