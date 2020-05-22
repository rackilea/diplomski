import java.util.Arrays;

public class Test {
  public static final float epsilon = Math.ulp(-180f);

  public static final float a [] = {
          -180.0f,
          -180.0f + epsilon * 2,
          -epsilon * 2
  };

  public static void main(String[] args) {
    System.out.println(Arrays.toString(a));
  }

}