public class BubbleSort {
    private int num;

public int[] getArray() {
    System.out.print("Enter the total number of elements in the Array :  ");
    Scanner sc = new Scanner(System.in);
    num = sc.nextInt();
    System.out.println(num);

    int[] arr = new int[num];

    System.out.print("Enter " + num + " Elements  : ");
    for (int i = 0; i < num; i++) {
        arr[i] = sc.nextInt();
    }
    return arr;
}

public void putArray(int num, int[] arr) {
    System.out.print("The Array is:  ");
    for (int i = 0; i < num; i++) {
        System.out.println(arr[i] + "  ");
    }
}

public void sortArray(int num, int[] arr) {
    for (int i = 0; i < num; i++) {
        boolean flag = false;
        for (int j = 0; j < num - i - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                arr[j] = arr[j] + arr[j + 1];
                arr[j + 1] = arr[j] - arr[j + 1];
                arr[j] = arr[j] - arr[j + 1];
                flag = true;
            }
        }
        if (!flag) {
            break;
        }
    }
}

public int getNum() {
    return num;
}

public void setNum(int num) {
    this.num = num;
}

    public static void main(String[] args) {

    int num = 0;
    int[] arr = null;
    BubbleSort b = new BubbleSort();

    arr = b.getArray();
    b.putArray(b.getNum(), arr);
    b.sortArray(b.getNum(), arr);
    b.putArray(b.getNum(), arr);        
}

}