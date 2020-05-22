public static <T> T findEager(EntityManager em, Class<T> type, Object id) {
    T entity = em.find(type, id);
    for (Field field: type.getDeclaredFields()) {
        OneToMany annotation = field.getAnnotation(OneToMany.class);
        if (annotation != null) {
            if (annotation.fetch().equals(FetchType.LAZY)) {
                try {
                    new PropertyDescriptor(field.getName(), type).getReadMethod().invoke(entity);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
    return entity;
}