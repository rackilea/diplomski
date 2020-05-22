Class<?> name = Class.forName("ClassName");
        Object instance = name.newInstance();
        Method[] methods = name.getMethods();

        for (Method method : methods) {
            if (method.getName().equals(N.getTCName())) {
                // Match found. Invoke the method. call the method on my demand.
                method.invoke(instance, null);
                break;
            }
        }