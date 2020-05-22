int numberOfObjects = 0;
    for(StoredClass storedClass : container.ext().storedClasses()){
        // Filter out db4o internal objects
        // and filter out object which have a parent-class, because these are in the count of the parent
        if(!storedClass.getName().startsWith("com.db4o") &&
                null==storedClass.getParentStoredClass()) {
            numberOfObjects += storedClass.instanceCount();
        }
    }
    System.out.println("Number of objects stored "+numberOfObjects);