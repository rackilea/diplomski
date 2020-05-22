if (component instanceof UIInput) {
    Object submittedValue = ((UIInput) component).getSubmittedValue();
    if (submittedValue != null) {
        // value may not be a String...
        return submittedValue.toString();
    }
}

String currentValue = null;
Object currentObj = getValue(component);
if (currentObj != null) {
    currentValue = getFormattedValue(context, component, currentObj);
}
return currentValue;