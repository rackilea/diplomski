public static void main(String[] args) throws Exception {
    Field field = Example.class.getField("field");
    AnnotatedParameterizedType annotatedParameterizedType = (AnnotatedParameterizedType) field
            .getAnnotatedType();

    System.out.println(annotatedParameterizedType
            .getAnnotatedActualTypeArguments()[0].getType());
    System.out.println(Arrays.toString(annotatedParameterizedType
            .getAnnotatedActualTypeArguments()[0].getAnnotations()));
}

@Retention(RetentionPolicy.RUNTIME)
@Target(value = { ElementType.TYPE_USE })
@interface Bar {
}

public List<@Bar String> field;