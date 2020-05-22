public class ClassThatNeedsToBeSerializedValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return ClassThatNeedsToBeSerialized.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        //Validate
    }
}