Type type = field.getGenericType();
if (type instanceof ParameterizedType) {
    ParamterizedType pt = (ParameterizedType) type;
    if (pt.getRawType() == List.class &&
        pt.getActualTypeArguments()[0] == Category.class) {
        ...
    }
}