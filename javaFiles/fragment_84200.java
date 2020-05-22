public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
  String containerNumber = (String)value;
  Object containerBean = component.getValueExpression("containerBean").getValue(context.getELContext());

  if(containerBean instanceof BeanA) {
    //do this
  }