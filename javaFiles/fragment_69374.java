import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;
import java.util.Arrays;

public class Main {

  public static void main(String[] args) {
    VarHandle varHandle = MethodHandles.arrayElementVarHandle(int[].class);

    int[] array = new int[5];

    printArray(array);
    varHandle.set(array, 2, 5);
    printArray(array);

    System.out.println(varHandle.get(array, 2));
  }

  private static void printArray(int[] array) {
    System.out.println(Arrays.toString(array));
  }

}