private <T> Object searchNeededObject(Class<T> theClass, List<T> list, String param) {
    Object result = null;

    // Checking if needed class is Image.class
    if (theClass.equals(Image.class)) {
        // Chacking in our list for needed object with help of param
        for (T item : list) {
        if (item instanceof Image) {
            Image neededImage = (Image) item;
            if (neededImage.getLinks().equals(param) || neededImage.getName().equals(param)) {
            // Have found needed object
            result = neededImage;
            }
        }
        }
    }
    return result;
    }