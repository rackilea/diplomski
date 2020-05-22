package cz.test;

import javax.faces.application.FacesMessage;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import org.apache.el.ValueExpressionLiteral;

public class RequiredValidator implements Validator {

public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
    if (value == null || "".equals(value.toString().trim())) {
        FacesMessage message = new FacesMessage();
        String messageStr = (String) component.getAttributes().get("message");
        if (messageStr == null) {
            messageStr = "Please enter data";
        }
        message.setDetail(messageStr);
        message.setSummary(messageStr);
        message.setSeverity(FacesMessage.SEVERITY_ERROR);
        component.setValueExpression("style", new ValueExpressionLiteral("background-color: yellow;", String.class));
        throw new ValidatorException(message);
    } else {
        component.setValueExpression("style", new ValueExpressionLiteral("", String.class));
    }
}
}