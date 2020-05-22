public Object getProperty(String property) {
    try {
        return binding.getVariable(property);
    } catch (MissingPropertyException e) {
        return super.getProperty(property);
    }
}

public void setProperty(String property, Object newValue) {
    if ("binding".equals(property))
        setBinding((Binding) newValue);
    else if("metaClass".equals(property))
        setMetaClass((MetaClass)newValue);
    else
        binding.setVariable(property, newValue);
}