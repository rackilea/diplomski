List<Class<?>> classes = new ArrayList<>();
for (Class<?> c = obj.getClass(); c != null; c = c.getSuperclass())
    classes.add(c);
Collections.addAll(classes, obj.getClass().getInterfaces());
Method m = classes.stream()
                  .map(Class::getDeclaredMethods)
                  .flatMap(Arrays::stream)
                  .filter(this::isAMatch)
                  .findFirst()
                  .orElse(null);