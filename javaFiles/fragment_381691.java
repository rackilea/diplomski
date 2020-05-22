private Set < Class << ? extends Object >> getClassInPackage(String packagePath) {
            Reflections reflections = new Reflections(packagePath,
                new SubTypesScanner(false));
            Set < Class << ? extends Object >> allClasses =
                reflections.getSubTypesOf(Object.class);
            return allClasses;
        }