public class MyValidator extends AbstractValidator {
    @Inject private Dao dao;

    public void render(Field field, String constraintValue, MessageFormatter formatter, MarkupWriter writer, FormSupport formSupport) {
        // this is the serverside representation of the field which will be rendered to HTML
        Element fieldElement = writer.getElement();
        List<String> values= dao.getSomeList(constraintValue);
        String valuesAsString = values.toString();

        // add an attribute to the DOM, this can be referenced in javascript later
        fieldElement.attribute("data-values", valuesAsString);
        formSupport.addValidation(...);
    }
}