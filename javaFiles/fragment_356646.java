Type type = B.class.getGenericSuperclass();

// TODO: check with instanceof first?
ParameterizedType parameterized = (ParameterizedType) type;

// TODO: Check that there *are* type arguments
Type firstTypeArgument = parameterized.getActualTypeArguments()[0];