public Object getAsObject(FacesContext context, UIComponent component, String value) {
    Long varId = Long.parseLong(value.trim());  
    List<CRVariable> cRVariables = mybean.getCRVariables();

    for (CRVariable cRVariable:cRVariables) {
        if(cRVariable.getVarId().compareTo(varId)==0){
            return cRVariable;
        }
    }

    return null;    
}