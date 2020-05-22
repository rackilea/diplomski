public class DataBinder implements PropertyEditorRegistry, TypeConverter {

    ....

    public void setValidator(Validator validator) {
        assertValidators(validator);
        this.validators.clear();
        this.validators.add(validator);
    }

    public void addValidators(Validator... validators) {
        assertValidators(validators);
        this.validators.addAll(Arrays.asList(validators));
    }

    ....

}