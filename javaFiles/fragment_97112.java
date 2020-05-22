public void clearAttributes() {
            if (attributes != null) {
                for (Map.Entry<String, Object> entry : attributes.entrySet())
                    attributeChanged(AttributeChangeEvent.REMOVE, entry.getKey(),
                            entry.getValue(), null);

                attributes.clear();
            }
        }
...
    public void setAttribute(String attribute, Object... values) {
        addAttribute(attribute, values);
    }
...
    public void addAttribute(String attribute, Object... values) {
        if (attributes == null)
            attributes = new HashMap<String, Object>(1);

        Object oldValue;
        Object value;
        if (values.length == 0)
            value = true;
        else if (values.length == 1)
            value = values[0];
        else
            value = values;

        AttributeChangeEvent event = AttributeChangeEvent.ADD;
        if (attributes.containsKey(attribute)) // In case the value is null,
            event = AttributeChangeEvent.CHANGE; // but the attribute exists.

        oldValue = attributes.put(attribute, value);
        attributeChanged(event, attribute, oldValue, value);
    }
...