Stream.of( this.getClass().getDeclaredFields() )
    .forEach( field -> Stream.of( field.getAnnotations() )
        .forEach( annotation -> System.out.printf( "@%s%n%s %s %s;%n",
            annotation.annotationType().getSimpleName(),
            Modifier.toString( field.getModifiers() ),
            field.getType().getSimpleName(),
            field.getName() ) ) );