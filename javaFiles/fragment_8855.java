public class MyTextConverter implements Converter {

    public String getAsString(FacesContext context, UIComponent component, Object value) {
        // Write code here to convert MyText to its unique String representation.
        return String.valueOf(((MyText) value).getId());
    }

    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        // Write code here to convert unique String representation of MyText to MyText object.
        return myTextService.find(Long.valueOf(value));
    }

}