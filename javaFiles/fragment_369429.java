package mypackage;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

public class DatePartConverter implements Converter {

    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        String part = (String) component.getAttributes().get("part");
        Date date = null;

        if (context.getRenderResponse()) {
            // Convert any default/selected date for display.
            Date selectedDate = (Date) ((UIInput) component).getValue();
            if (selectedDate != null) {
                if (("day".equals(part) && new SimpleDateFormat("d").format(selectedDate).equals(value))
                    || ("month".equals(part) && new SimpleDateFormat("M").format(selectedDate).equals(value))
                    || ("year".equals(part) && new SimpleDateFormat("yyyy").format(selectedDate).equals(value)))
                {
                    date = selectedDate;
                }
            }
        } else {
            // Convert submitted date after submit.
            Map<String, Object> map = context.getExternalContext().getRequestMap();
            if ("day".equals(part)) {
                map.put("DatePartConverter.day", value); // Save until we have all parts.
            } else if ("month".equals(part)) {
                map.put("DatePartConverter.month", value); // Save until we have all parts.
            } else if ("year".equals(part)) {
                String day = (String) map.get("DatePartConverter.day");
                String month = (String) map.get("DatePartConverter.month");
                String dateString = String.format("%s-%s-%s", day, month, value);

                try {
                    date = new SimpleDateFormat("d-M-yyyy").parse(dateString);
                } catch (ParseException e) {
                    throw new ConverterException(new FacesMessage(e.getMessage()), e);
                }
            }
        }

        return date;
    }

}

    public String getAsString(FacesContext context, UIComponent component, Object value) {
        // Not relevant here. Just return SelectItem's value.
        return (String) value;
    }