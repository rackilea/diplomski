private static List<Long> getIds(String name, List<?> objects) {
    List<Long> ids = new ArrayList<>();
    for (Object object : objects) {
        try {
            Method getName = null;
            Method getId = null;

            for (Method method : object.getClass().getMethods()) {
                if (method.getName().equals("getName") && method.getReturnType().equals(String.class) && method.getParameterTypes().length == 0) {
                    getName = method;
                }
                if (method.getName().equals("getId") && method.getReturnType().equals(Long.class) && method.getParameterTypes().length == 0) {
                    getId = method;
                }
                if (getName != null && getId != null && getName.invoke(object).equals(name)) {
                   ids.add((Long) getId.invoke(object));
                   break;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    return ids;
}