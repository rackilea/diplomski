@Component
public class MyValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return MyBean.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        MyBean myBean = (MyBean) target;

        if (StringUtils.isBlank(myBean.getProperty("state"))) {
            errors.rejectValue("state", "blank");
        }
    }

}