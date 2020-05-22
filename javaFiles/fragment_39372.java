package sample;
public class SampleComplexity {
  public static int p5(int N) {
    int res = 0;
    for (int i = 1; i <= N * N; i *= 2) {
      for (int j = 0; j < i; j++) {
        //count operations here
        res++;
      }
    }
    return res;
  }

  public static void main(String[] args) {
    int N=1;
    for (int i=0;i<10;i++) {
      int p5 = p5(N);
      System.out.printf("p5 N=%d took op=%d operations, ratio=%f%n", N, p5, 1.*p5/N/N);
      N=N*2;
    }
  }
}