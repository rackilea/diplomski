class Main
{
  public static void main(String[] args)
  {
    Singleton.currentPath = "somepath";
    ...
  }
}

class Singleton
{
  public static String currentPath = null;
  private static Singleton instance;
  private SomeDataObject data;

  private Singleton(String path) { loadDataFromFile(path); ... }

  public static Singleton getInstance() {
     if(instance == null && currentPath != null)
        instance = new Singleton(currentPath);
     return instance;
  }
}