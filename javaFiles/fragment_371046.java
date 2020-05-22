@SuppressWarnings("unchecked")
public static Map<String, Object> getSessionMap() {
    FacesContext context = FacesContext.getCurrentInstance();
    return context.getExternalContext().getSessionMap();
}


private void clearMyfacesSessionAttributes() {
    RequestContext requestContext = RequestContext.getCurrentInstance();
    requestContext.getPageFlowScope().clear();
    Map<String, Object> sessionMap = getSessionMap();
    Set<Map.Entry<String, Object>> entrySet = sessionMap.entrySet();
    for (Map.Entry<String, Object> entry : entrySet) {
        String key = entry.getKey();
        if(key.contains("org.apache.myfaces.trinidadinternal.application.VIEW_CACHE")
                || key.contains("org.apache.myfaces.trinidadinternal.application.PageFlowScope")
                || key.contains("org.apache.myfaces.trinidadinternal.Change"))
        {
            sessionMap.remove(key);
        }
    }
}