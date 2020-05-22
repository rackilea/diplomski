Object around(): embeddedGetter() {
    Object value = proceed();
    if (value == null) {
        String fieldName = thisJoinPoint.getSignature().getName();
        Object obj = thisJoinPoint.getThis();

        try{
            Field field = obj.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(obj, value = new Validity() );
        }
        catch( IllegalAccessException | NoSuchFieldException e){e.printStackTrace();}           
    }
    return value;
}