@FacesConverter(value = "anotherConverter")
public class AnotherConverter extends EntityConverter {

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value instanceof Document && ((Document) value).getId() == null) {
            return String.valueOf(((Document) value).hashCode());
        }
        return super.getAsString(context, component, value);
    }
}