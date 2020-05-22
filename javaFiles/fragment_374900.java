@Service
public class WriteOnlyListener extends AbstractMongoEventListener<Entity> {

    @Override
    public void onAfterLoad(AfterLoadEvent<Entity> event) {
        Document doc = event.getDocument();
        if (doc == null) return;
        for (Field field: getWriteOnly(event.getType(), Class::getDeclaredFields)) {
            doc.remove(field.getName());
        }
        for (Method method: getWriteOnly(event.getType(), Class::getDeclaredMethods)) {
            doc.remove(getFieldName(method.getName()));
        }
    }

    private <T extends AccessibleObject> List<T> getWriteOnly(Class<?> type, 
                                                              Function<Class<?>, T[]> extractor) {
        List<T> list = new ArrayList<>();
        for (Class<?> c = type; c != null; c = c.getSuperclass()) {
            list.addAll(Arrays.stream(extractor.apply(c))
                    .filter(o -> o.isAnnotationPresent(WriteOnly.class))
                    .collect(Collectors.toList()));
        }
        return list;
    }

    private static String getFieldName(String methodName) {
        return Introspector.decapitalize(methodName.substring(methodName.startsWith("is") ? 2 : 
                    methodName.startsWith("get") ? 3 : 0));
    }

}