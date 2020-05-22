@Named
@FacesValidator("uniqueValueValidator")
public class UniqueValueValidator implements Validator {

    @Inject
    private DBService service;

    @Override
    public void validate(FacesContext context, UIComponent component, Object obj) {

        Object inputValue = ((UIInput) context.getViewRoot().findComponent("formId:value")).getSubmittedValue();

        if(service.isValueNotUnique((String) inputValue) {
            // throw ValidatorException 
        }
    }

}