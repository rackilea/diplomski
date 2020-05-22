for (Annotation annotation : annotations) {
        if (annotation instanceof QueryParam) {
            QueryParam param = (QueryParam) annotation;
            // ...
        } else if (annotation instanceof PathParam) {
            PathParam param = (PathParam) annotation;
            // ...
        } else if (annotation instanceof MatrixParam) {
            MatrixParam param = (MatrixParam) annotation;
            // ...
        }
        // ... and so on
    }