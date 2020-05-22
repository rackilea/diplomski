if (component instanceof UIInput && !((UIInput) component).isValid()) {
    Object submittedValue = ((UIInput) component).getSubmittedValue();
    if (submittedValue != null) {
        // value may not be a String...
        return submittedValue.toString();
    } else {
        return null;
    }
}