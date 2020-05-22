public static <T> T getInstance(final Class<T> type, final String elExpression){
    return JsfUtils.getInstance(type, FacesContext.getCurrentInstance(), elExpression);
}


public static <T> T getInstance(final Class<T> type, final FacesContext context, final String elExpression){
    return context.getApplication().evaluateExpressionGet(context, elExpression, type);
}