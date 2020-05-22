public static String  getFieldNamesAndValues(final Object obj, boolean publicOnly)
            throws IllegalArgumentException, IllegalAccessException {
        Class<? extends Object> c1 = obj.getClass();
        System.out.println("Class value is c1:::" + c1);
        Map<String, Object> map = new HashMap<String, Object>();
        Field[] fields = c1.getDeclaredFields();
        System.out.println("Fields in objects :: " + fields.toString());
        System.out.println("Xpath Before for loop::: " + fields.getClass());
        for (int i = 0; i < fields.length; i++) {
            String name = fields[i].getName();
            System.out.println("Fields name ::: " + name);
            if (publicOnly) {
                if (Modifier.isPublic(fields[i].getModifiers())) {
                    Object value = fields[i].get(obj);
                    map.put(name, value);
                }
            } else {
                fields[i].setAccessible(true);
                Object value = fields[i].get(obj);
                map.put(name, value);
            }
        }
        System.out.println("Return on object is ::::--> " + map.get("selectorCollection").toString());
        return (String) map.get("selectorCollection");
    }