public class RunMthdRef {
  public int add(int a, int b) {
    return a+b;
  }

  public int sub(int a, int b) {
    return a-b;
  }

  public int mul(int a, int b) {
    return a*b;
  }

  public int div(int a, int b) {
    return a/b;
  }

  public static void main(String[] args) {
    try {
      Integer[] input={new Integer(2),new Integer(6)};
      Class cl=Class.forName("RunMthdRef");
      Class[] par=new Class[2];
      par[0]=Integer.TYPE;
      par[1]=Integer.TYPE;
      Method mthd=cl.getMethod("add",par);
      Integer output=(Integer)mthd.invoke(new RunMthdRef(),input);
      System.out.println(output.intValue());
    } catch (Exception e) {
      e.printStackTrace();
    } 
  }
}