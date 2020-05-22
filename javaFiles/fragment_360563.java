public static void main(final String[] args){

    final StringBuilder ib = new StringBuilder(); // interface builder
    final StringBuilder sb = new StringBuilder(); // method builder
    for(final Class<? extends Annotation> annotationType : Arrays
        .asList(
            // all lifecycle annotations:
            PrePersist.class, PostPersist.class, PreRemove.class,
            PostRemove.class, PreUpdate.class, PostUpdate.class,
            PostLoad.class)){

        final String annotationName = annotationType.getSimpleName();
        final String lower =
            annotationName
                .substring(0, 1)
                .toLowerCase()
                .concat(annotationName.substring(1));

        ib.append("public interface ")
            .append(annotationName)
            .append("Support{\n\tvoid ")
            .append(lower)
            .append("();\n}\n\n");

        sb.append('@')
            .append(annotationName)
            .append(" public void ")
            .append(lower)
            .append("(Object entity){\nif(entity instanceof ")
            .append(annotationName)
            .append("Support){((")
            .append(annotationName)
            .append("Support)entity).")
            .append(lower)
            .append("();}}\n\n");

    }
    System.out.println(ib.toString());
    System.out.println(sb.toString());

}