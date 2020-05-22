public static <T> T[] getObjectFromList(List<? extends T> inputList, Class<T> c) {
    if (inputList == null || inputList.isEmpty()) {
        inputList = new ArrayList<T>();
        T obj = null;
        try {
            obj = c.newInstance();
        } (Exception ex) {
            throw new RuntimeException("Instantiation failed", ex);
        }
        inputList.add(obj);
    }             
    return inputList.toArray(Array.newInstance(c, inputList.size()));            
}