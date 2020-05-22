Object parentClassInstance = parentClass.newInstance();
Class componentClass = Class.forName(clazz.getName());
Object componentClassInstance = componentClass.newInstance();
Field field = parentClass.getDeclaredField(Introspector
                        .decapitalize(clazz.getSimpleName()));
field.setAccessible(true);
field.set(parentClassInstance, componentClassInstance);