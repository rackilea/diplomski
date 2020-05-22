public class MyTransformer implements IAnnotationTransformer {
  private MyParentClass parent;
  public MyTransformer(MyParentClass parent){
      this.parent = parent;
  }
  public void transform(ITest annotation, Class testClass,
      Constructor testConstructor, Method testMethod)
  {
    if (checkConditionForMethod(testMethod.getName())) {
      annotation.setEnabled(false);
    }
  }
  public boolean checkConditionForMethod(String methodName){
       return parent.isValidSwitchForMethod(methodName);
  }
}