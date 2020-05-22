public class VisitorUpdateModelWithoutValidation implements FormComponent.IVisitor {

public Object formComponent(IFormVisitorParticipant formComponent) {
        if (formComponent instanceof FormComponent) {
            final FormComponent<?> formComponent1 = (FormComponent<?>) formComponent;
            boolean required = formComponent1.isRequired();
            if (required) {
                formComponent1.setRequired(false);
            }
            formComponent1.modelChanging();
            formComponent1.validate();
            formComponent1.updateModel();
            formComponent1.modelChanged();
            if (required) {
                formComponent1.setRequired(true);
            }
        }

        return Component.IVisitor.CONTINUE_TRAVERSAL;
    }
}