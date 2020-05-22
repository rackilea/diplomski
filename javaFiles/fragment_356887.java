public class ret {
  public static void foo(int arr[]) {
    arr[0] = -100;
  }

  public static void main(String argv[]) {
    int arr[] = new int[10];
    System.out.println(arr[0]);
    foo(arr);
    System.out.println(arr[0]);
  }
}