public static <T> List<T> getCastedList(List<Object> objList, Class<T> clazz) {
        List<T> newList = new ArrayList<T>();
        if (objList != null) {
            for (Object object : objList) {
                if (object != null && clazz.isAssignableFrom(object.getClass())) {
                    newList.add((T) object);
                }
            }
        }
        return newList;
    }