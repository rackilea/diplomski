public Object getAsObject(FacesContext arg0, UIComponent arg1, String newValue) {
    return (Object) newValue.replaceAll("&nbsp;", " ");
}

public String getAsString(FacesContext arg0, UIComponent arg1, Object value) { 
    return value.toString().replaceAll(" ", "&nbsp;"); 
}