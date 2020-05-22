class StartupWrapper {

  public static void main(String[] args) throws Exception {
    Class.forName("com.company.Main", true, 
        new ParentLastURLClassLoader(Arrays.asList(new URL("./new-JAXB.jar"))))
      .getMethod("main", String[].class).invoke(null, args);
  }
}