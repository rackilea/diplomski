ConfigurableApplicationContext context = SpringApplication.run(EventServiceApplication.class, args);

List<Class<?>> classes = // load classes

classes
.stream()
.filter(clazz -> clazz.isAnnotationPresent(Component.class) || Arrays.stream(clazz.getAnnotations()).anyMatch(annotation -> annotation.annotationType().isAnnotationPresent(Component.class)))
.forEach(applicationContext::register);