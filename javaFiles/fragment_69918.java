public class MaxHeap {

public int[] myHeap = new int[20];
public int begin = 0;
public int current = 0;

public int getParent(int index){
    return (index - 1)/2;
}

public int getLeftChild(int index){
    return 2*index+1;
}

public int getRighChild(int index){
    return 2*index+2;
}

public void insert(int data) {

    myHeap[current] = data;

    int i = current;
    int tmp;
    int parent;
    while(i > 0){
        parent = getParent(i);

        System.out.println(" I value"+i+" parent"+parent+" data"+data);
        if(myHeap[parent] < myHeap[i]){
            tmp = myHeap[parent];
            myHeap[parent] = myHeap[i];
            myHeap[i] = tmp;
        } else{
            break;
        }

        i = parent;

    }
    current++;
}