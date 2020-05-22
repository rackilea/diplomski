public class MyFormValidator implements Validator {

    @Override
    public boolean supports(Class clazz) {
        return MyForm.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        MyForm myForm = (MyForm) target;

        for (int i = 0; i < myForm.getListObjects().size(); i++) {
            TypeA typeA = myForm.getListObjects().get(i);

            if(typeAHasAnErrorOnNumber) {
                errors.rejectValue("listObjects[" + i + "].number", "your_error_code");
            }

            ...
        }

        ...
    }

}