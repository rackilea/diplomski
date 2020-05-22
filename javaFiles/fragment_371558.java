public class Test {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    CustomArray c = new CustomArray(3);
    boolean flag = true;
    while (flag) {
        int num = sc.nextInt();

        if (num == -1) {
           flag = false;
        } else {
           c.insert(num);
        }
        System.out.println(Arrays.toString(c.numList));
    }
    sc.close();
    }

}

class CustomArray {
    int[] numList;
    int size; // size of numList[]
    int numOfElements; // integers present in  numList[]

    public CustomArray(int size) {
       // TODO Auto-generated constructor stub
       numList = new int[size];
       this.size = size;
       numOfElements = 0;
    }

    void insert(int num) {
    if (numOfElements < size) {
        numList[numOfElements++] = num;
    } else {
        // list is full
        size = size * 2; //double the size, you can use some other factor as well
        //create a new list with new size
        int[] newList = new int[size];
        for (int i = 0; i < numOfElements; i++) {
           //copy all the elements in new list
           newList[i] = numList[i];
        }

        numList = newList;//make numList equal to new list
        numList[numOfElements++] = num;
    }
    }
}