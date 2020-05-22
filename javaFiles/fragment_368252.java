public interface MyConstants {
 public String myConstant(); 
}

public class MyConstantsDev implements MyConstants {
 public String myConstant() { return "xyzzy-dev"; };
}

public class MyConstantsProd implements MyConstants {
 public String myConstant() { return "xyzzy-prod"; };
}