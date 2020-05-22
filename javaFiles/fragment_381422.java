/**
 * @param name the name of the variable to lookup
 * @return the variable value
 */
public Object getVariable(String name) {
    if (variables == null)
        throw new MissingPropertyException(name, this.getClass());

    Object result = variables.get(name);

    if (result == null && !variables.containsKey(name)) {
        throw new MissingPropertyException(name, this.getClass());
    }

    return result;
}

/**
 * Sets the value of the given variable
 *
 * @param name  the name of the variable to set
 * @param value the new value for the given variable
 */
public void setVariable(String name, Object value) {
    if (variables == null)
        variables = new LinkedHashMap();
    variables.put(name, value);
}