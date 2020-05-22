public String updateCurrent() {
    FacesContext context = FacesContext.getCurrentInstance();
    setCurrent((String) context.getExternalContext()
         .getRequestParameterMap().get("current"));
    return null;
}