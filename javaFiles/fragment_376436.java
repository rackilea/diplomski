@FacesConverter("commaSeparatedFieldConverter")
public class CommaSeparatedFieldConverter implements Converter {

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null) {
            return null;
        }

        String[] strings = (String[]) value;
        StringBuilder builder = new StringBuilder();

        for (String string : strings) {
            if (builder.length() > 0) {
                builder.append(",");
            }

            builder.append(string);
        }

        return builder.toString();
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null) {
            return null;
        }

        return value.split(",");
    }

}