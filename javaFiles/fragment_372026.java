public T bind(T target, Map<String, String> newValues) {
    DataBinder binder = new DataBinder(target);
    binder.setAllowedFields(getAllowedFields());
    binder.bind(new MutablePropertyValues(newValues));
    return target;
}