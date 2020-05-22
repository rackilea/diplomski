public void method method(Object obj) {
        Map initializedFieldsMap = new HashMap();

        for (Field field : obj.getClass().getDeclaredFields()) {
            Boolean acessibleState = field.isAccessible();
            field.setAccessible(true);
            Object value;
            try {
                value = field.get(obj);
                if (value != null) {
                    initializedFieldsMap.put(field.getName(), new WeakReference(value));
                }
            } catch (IllegalArgumentException e) {
            } catch (IllegalAccessException e) {
            }
            field.setAccessible(acessibleState);
        }
        return initializedFieldsMap;
    }