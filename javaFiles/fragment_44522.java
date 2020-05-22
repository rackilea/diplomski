@FacesConverter(value="userConverter")
public static class UserConverter implements Converter {
  public Object getAsObject(FacesContext facesContext, 
                    UIComponent component, String value) {
    // your code to convert String to Object
  }

  public String getAsString(FacesContext facesContext, 
                    UIComponent component, Object object) {
    // your code to convert Object to String
  }