import java.util.*;

import jcuda.*;
import static jcuda.jcublas.JCublas.*;

public class Main {

  private static final int VECTOR_SIZE = 10;

  static {
    Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {

      @Override
      public void run() {
        cublasShutdown();
      }

    }));

    cublasInit();
  }

  static void printArrays(float[] a1, float[] a2) {
    System.out.println("\t" + Arrays.toString(a1));
    System.out.println("\t" + Arrays.toString(a2));
    System.out.println();
  }

  public static void main(String[] args) {
    float[] a1 = new float[VECTOR_SIZE];
    float[] a2 = new float[VECTOR_SIZE];

    for (int i = 0; i < VECTOR_SIZE; ++i) {
      a1[i] = i + 1;
    }

    Pointer p1 = new Pointer();
    Pointer p2 = new Pointer();

    cublasAlloc(VECTOR_SIZE, Sizeof.FLOAT, p1);
    cublasAlloc(VECTOR_SIZE, Sizeof.FLOAT, p2);

    System.out.println("BEFORE:");
    printArrays(a1, a2);

    cublasSetVector(VECTOR_SIZE, Sizeof.FLOAT, Pointer.to(a1), 1, p1, 1);
    cublasSetVector(VECTOR_SIZE, Sizeof.FLOAT, Pointer.to(a2), 1, p2, 1);

    // THE ACTUAL OPERATION: MULTIPLY AND ADD
    cublasSaxpy(VECTOR_SIZE, 20f, p1, 1, p2, 1);

    cublasGetVector(VECTOR_SIZE, Sizeof.FLOAT, p2, 1, Pointer.to(a2), 1);

    System.out.println("AFTER:");
    printArrays(a1, a2);

    cublasFree(p1);
    cublasFree(p2);
  }

}