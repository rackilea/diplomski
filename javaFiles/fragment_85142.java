public class RecurList {
    static int[] list; 
 public static void main(String[] args) {
    list = {8,7,9,10,56};

    int ix = list.length;
    int sumNow = ShowNext(ix, 0);  // initial call -> sum is 0

    System.out.println("Recursion total is " + sumNow);
  }   
  public static int ShowNext(int inx, int sum) {
        if (inx == 0) return sum;
        int item = lst[inx - 1];
        sum += item;
        System.out.println("inx:" + inx + " item:" + item + " sum:" + sum);
        return ShowNext(inx - 1, sum);
    }
}