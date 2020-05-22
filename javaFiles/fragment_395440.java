void around () : generic()  {

    Annotation[] classAnnotations = thisJoinPoint.getThis().getClass().getAnnotations();

    String ArgumentValue = null;
    for ( Annotation annotation : classAnnotations ) {
        if ( annotation instanceof Anno1 ) {
            ArgumentValue = ((Anno1) annotation).Argument(); 
            break;
        }
    }

    if ( ArgumentValue != null && ArgumentValue.equals("Option1")) {
        z.invokeToAll();
    }

}