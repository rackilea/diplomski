@FacesConverter("MyBigDecimalConverter")
public class MyBigDecimalConverter extends NumberConverter {
@Override
public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
    try {
        HtmlInputText it = (HtmlInputText) arg1;
        ValueExpression ve = it.getValueExpression("value");
        String expression = ve.getExpressionString();
        String field = expression.replaceAll("#\\{.*\\.", "");
        field = field.replace("}", "");
        String parent = expression.replace("." + field, "");
        ExpressionFactory expressionFactory = arg0.getApplication().getExpressionFactory();
        ValueExpression exp = expressionFactory.createValueExpression(arg0.getELContext(), parent, Object.class);
        Object obj = exp.getValue(arg0.getELContext());

        Digits d = null;    
        Field f = obj.getClass().getDeclaredField(field);
        d = f.getAnnotation(Digits.class);
        return super.getAsObject(arg0, arg1, arg2);
    } catch (ConverterException e) {
        FacesMessage msg = new FacesMessage(d.message());
        msg.setSeverity(FacesMessage.SEVERITY_ERROR);
        throw new ConverterException(msg);
    } catch (Exception e) {
        return super.getAsObject(arg0, arg1, arg2);
    }
}

@Override
public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
    return super.getAsString(arg0, arg1, arg2);
}

}