package privateaccessor.tst;
public class ProjectModel {
  //some code
  private static class MyStaticClass{
    private int model (Object obj, Map<String , Object> model) {
      return 42;
    }
  }
}