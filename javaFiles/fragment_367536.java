ClassPathScanningCandidateComponentProvider scanner = new ClassPathScanningCandidateComponentProvider(false);
scanner.addIncludeFilter(new AnnotationTypeFilter(ControllerAdvice.class));
scanner.findCandidateComponents("org.example") // Change the package name
        .stream()
        .filter(AnnotatedBeanDefinition.class::isInstance)
        .map(AnnotatedBeanDefinition.class::cast)
        .forEach(annotatedBeanDefinition -> {
            System.out.println(
                    annotatedBeanDefinition.getBeanClassName() + ": " +
                    annotatedBeanDefinition.getMetadata().getAllAnnotationAttributes(Order.class.getName())
            );
        });