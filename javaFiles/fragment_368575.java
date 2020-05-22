public void process(Class<?> clazz, Object testInstance) {
        Field[] fields = clazz.getDeclaredFields(); //This is the line of concern
        for (Field field : fields) {
            boolean alreadyAssigned = false;
            for(Annotation annotation : field.getAnnotations()) {           
                Object mock = createMockFor(annotation, field);
                if (mock != null) {
                    throwIfAlreadyAssigned(field, alreadyAssigned);                    
                    alreadyAssigned = true;                    
                    try {
                        new FieldSetter(testInstance, field).set(mock);
                    } catch (Exception e) {
                        throw new MockitoException("Problems setting field " + field.getName() + " annotated with "
                                + annotation, e);
                    }
                }        
            }
        }