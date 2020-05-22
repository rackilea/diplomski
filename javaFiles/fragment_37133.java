Map<String, Method> methods = new HashMap<String, Method>();
        for (Method m: MethodTester.class.getMethods()) {
            methods.put(m.getName(), m);
        }

        if (methods.containsKey(selection)) {
            methods.get(selection).invoke(test);
        } else {
            System.err.println("No such method: " + selection);
        }