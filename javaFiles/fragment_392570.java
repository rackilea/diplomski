Field[] classFields = yourObjectPrePersist.getClass().getDeclaredFields();
for (int i = 0; i < classFields.length; i++) {
        classFields[i].setAccessible(true);//take notice that if you use a SecurityManager, you should work around it
        if (classFields[i].getAnnotation(NotNull.class) != null) {
            Object value = classFields[i].get(yourObjectPrePersist);
            //here check if value is null or not and then return the message
            if (value == null) {
                throw new SomeException(((NotNull) classFields[i].getAnnotation(NotNull.class)).message());
            }
        }
    }