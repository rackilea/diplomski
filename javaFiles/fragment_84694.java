public static <T extends Serializable> List<T> readFolder(Class<T> clazz, File file, List<String> exceptions){
    File[] files = file.isDirectory() ? file.listFiles() : new File[]{file};

    List<T> objects = new ArrayList<T>();

    for ( File f : files ){
        try (ObjectInputStream ois = new ObjectInputStream( new FileInputStream(f) ) ) {
            T object = clazz.cast( ois.readObject() );
            objects.add(object);
        } catch (Exception e) {
            exceptions.add( e.getMessage() );  
        }
    }        
    return objects;
}