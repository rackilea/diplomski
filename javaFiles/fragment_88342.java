return classes.stream()
                .flatMap(c -> Arrays.stream(c.getDeclaredMethods()))
                .flatMap(m -> Arrays.stream(m.getAnnotations())
                        .filter(stepAnnotation -> stepAnnotation.annotationType().isAnnotationPresent(StepDefAnnotation.class))
                        .map(ann -> new AbstractMap.SimpleEntry<>(ann.toString(), m)))
                .collect(Collectors.toMap(AbstractMap.SimpleEntry::getKey, AbstractMap.SimpleEntry::getValue));