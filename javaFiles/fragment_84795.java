public <T> List<T> findByAttribute(T object) {
    List<T> found = new ArrayList<T>();
    Map m = null;
    try {
        m = BeanUtils.describe(object);
    } catch (Exception ex) {
        return null;
    }

    String query = "select c from " + object.getClass().getSimpleName() + " c  where ";
    if (m != null) {
        for (Object key : m.keySet()) {
            if (!key.equals("class")) {
                Object value = m.get(key);

                if (value != null) {
                    try {
                        ConvertUtils.convert(m.get(key), PropertyUtils.getPropertyType(object, key.toString()));
                        query += " c." + key + " = :" + key + " and";

                    } catch (Exception ex) {
                        // the reason for this noncy try catch is so that you don't add parameters that are not primitives
                    }
                }
            }
        }
        query = query.substring(0, query.lastIndexOf("and"));
        Query q = getEntityManager().createQuery(query);
        for (Object key : m.keySet()) {
            if (!key.equals("class")) {
                if (m.get(key) != null) {
                    try {
                        Object o = ConvertUtils.convert(m.get(key), PropertyUtils.getPropertyType(object, key.toString()));
                        q.setParameter(key.toString(), o);
                    } catch (Exception ex) {
                        System.out.println("what we have here is a failure to communicate");
                        System.out.println("only primitive types allowed");
                    }
                }
            }
        }
        List resultList = q.getResultList();
        if (resultList != null) {
            found.addAll(resultList);
        }
    }
    return found;
}