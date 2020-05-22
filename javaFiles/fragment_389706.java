final Set<Annotation> annotations = ip.getQualifiers();
        for (final Annotation a : annotations) {
            try {
                if (a.annotationType().isAssignableFrom(annotationClass)) {
                    t = (T) a;
                    break;
                }
            }
            catch (final ClassCastException e) {
            }
        }`