@Override
    public PropertyName findRootName(AnnotatedClass ac) {
        // if this is an array, look for JsonRootNamePlural annotation in
        // the base type for the array (the so called array component)
        if (ac.getRawType().isArray()) {
            Class<?> arrayComponent = ac.getRawType().getComponentType();

            JsonRootNamePlural ann = arrayComponent.getAnnotation(JsonRootNamePlural.class);
            if (ann != null) {
                return PropertyName.construct(ann.value(), null);
            }

        }

        // super class will look for default @JsonRootName annotation
        return super.findRootName(ac);
    }