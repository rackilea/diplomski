Method[] methods=Class.forName("name of the entity").getDeclaredMethods();
for (Method method : m) {
                if (method.getAnnotation(JoinColumn.class) != null) {
                    System.out.println("Getter is:" + method.getName());
                }
                break;
            }