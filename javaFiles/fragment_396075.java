private static Singleton instance;
private SomeDataObject data;

private Singleton(String path) { loadDataFromFile(path); ... }

public static Singleton getInstance() {
   return instance;
}

public static void init(String dataPath){
   instance = new Singleton(dataPath);
}