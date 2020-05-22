import java.util.Arrays;

public class Test {
  public static void main(String[] args) {
    testIt(new int[]{});
    testIt(new int[]{4, 1, 1, 3, 3, 3, 1, 1});
    testIt(new int[]{1});
    testIt(new int[]{1,1});
    testIt(new int[]{1,2});
  }

  public static void testIt(int[] in) {
    System.out.println(Arrays.toString(in));
    squeeze(in);
    System.out.println(Arrays.toString(in));
    System.out.println();
  }

  public static void squeeze(int[] data) {
    int readIndex = 0;
    int writeIndex = 0;
    while(readIndex < data.length){
      if(readIndex == 0 || data[readIndex] != data[readIndex-1]){
        // Need to store this one
        data[writeIndex] = data[readIndex];
        writeIndex++;
      }
      readIndex++;
    }
    while(writeIndex < data.length){
      data[writeIndex] = -1;
      writeIndex++;
    }
  }
}