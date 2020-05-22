File folder = new File("JavaClassesPath");
    ArrayList<String> all = new ArrayList<>();
    for (final File fileEntry : folder.listFiles()) {
        if (!fileEntry.isDirectory()) {
            all.add(fileEntry.getName().substring(0, fileEntry.getName().lastIndexOf('.')));
        }
    }

    String className = "PackageName";

    for (String s: all) {
        if (!s.equals("AbstractClassName")) {
            Class<?> clazz = Class.forName(className + '.' + s);
            Constructor<?> ctor = clazz.getConstructor();
            Object object = ctor.newInstance();
            allHandlers.add((RequestHandler) object);
        }
    }

    for(int i=0; i<allHandlers.size()-1; i++){
        allHandlers.get(i).setNextHandler(allHandlers.get(i+1));
    }