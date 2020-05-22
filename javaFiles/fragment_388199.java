List<MethodConstraintViolation<?>> violations = new ArrayList<MethodConstraintViolation<?>>(exception.getConstraintViolations());

    for(MethodConstraintViolation<?> violation : violations)
    {
        String field = getFieldName(violation);
        String message = violation.getMessage();

        for(Class<? extends Payload> payload : new ArrayList<Class<? extends Payload>>(violation.getConstraintDescriptor().getPayload()))
        {
            //Retrieve field name from constraint payload
            if(payload.isAssignableFrom(FieldNamePayload.UserName.class))
            {
                field = getPayloadValue(payload);
            }
        }

        //Create an error response here!
    }