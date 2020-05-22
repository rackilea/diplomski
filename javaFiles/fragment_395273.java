/**
 * {@inheritDoc} 
 */
@Override
public Object getAsObject(FacesContext context, UIComponent component, String value) {
    Integration integration = new Integration();
    String[] split = value.split("_");
    integration.setId(split[0]);
    integration.setName(split[1]);
    return integration;
}

/**
 * {@inheritDoc} 
 */
@Override
public String getAsString(FacesContext context, UIComponent component, Object value) {
    Integration i = (Integration) value;
    return i.getId() + "_" + i.getName();
}