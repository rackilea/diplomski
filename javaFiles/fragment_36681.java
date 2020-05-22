class ClassFinder{
  public static final String[] searchPackages = {
    "java.lang",
    "java.util",
    "my.company",
    "my.company.other" };

  public Class<?> findClassByName(String name) {
    for(int i=0; i<searchPackages.length; i++){
      try{
        return Class.forName(searchPackages[i] + "." + name);
      } catch (ClassNotFoundException e){
        //not in this package, try another
      } catch (...){
        //deal with other problems...
      }
    }
    //nothing found: return null or throw ClassNotFoundException
    return null;
  }
}