Class<?> myClass = String.class;
        try {
            Object objectOfClass = myClass.newInstance();
        } catch (InstantiationException | IllegalAccessException e1) {
            e1.printStackTrace();
        }