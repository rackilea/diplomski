private int value;

public int getValue() {
    return value;
}

public void setValue(int value) {
    this.value = value;
}

...
public void validateInputHours(FacesContext context, UIComponent component,
        Object value) throws ValidatorException {
    Integer hours = (Integer) value; // the value will be the value from the model after the Apply-Request-Values phase is complete
    if (hours < 0 || hours > 24) {
        throw new ValidatorException(new FacesMessage(
                FacesMessage.SEVERITY_ERROR, "Not valid",
                "Not valid"));
    }
}