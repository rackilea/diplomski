public class Heap{
    Comparable [] heap=new Comparable[1000];
    int size=0;
    Heap() {        
    }
    public void HeapifyDownwards (int index){
        int left_child=2*index+1;
        int right_child=2*index+2;

        Comparable right= heap[right_child];
        Comparable left= heap[left_child];
        Comparable node = heap[index];

        if (size>right_child){
            // both right and left child exist
            if ((node.compareTo(right)>0) && (node.compareTo(left)>0)){
                return;
            }
            else if ((right.compareTo(node)>0) && (right.compareTo(left)>0)){
                Comparable temp=right;
                heap[right_child]=node;
                heap[index]=temp;
                HeapifyDownwards(right_child);
            }
            else if ((left.compareTo(node)>0) && (left.compareTo(right)>0)){
                Comparable temp=left;
                heap[left_child]=node;
                heap[index]=temp;
                HeapifyDownwards(left_child);
            }
        }
        else if (size==right_child){
            //only left child exists
            if (left.compareTo(node)>0){
                Comparable temp=left;
                heap[left_child]=node;
                heap[index]=temp;
                HeapifyDownwards(left_child);
            }
            else {return;}
        } 
        else {
            return;
        }
    }
    public void HeapifyUpwards (int index){
        int parent_index=(index-1)/2;

        Comparable parent= heap[parent_index];
        Comparable node = heap[index];

        if (node.compareTo(parent)>0){
            Comparable temp= parent;
            heap[parent_index]=node;
            heap[index]=temp;
            HeapifyUpwards(parent_index);
        }
        else{
            return;
        }
    }
    public void Insert (Comparable in){
        heap[size]=in;
        size++;
        HeapifyUpwards(size-1);
    }
    public Comparable Remove (){
        Comparable out=heap[0];
        heap[0]=heap[size-1];
        size--;
        HeapifyDownwards(0);
        return out;
    }
}


public class TestObject implements Comparable{
    int value;
    TestObject (int a) {
        value=a;
    }

    @Override
    public int compareTo (Object b){
         if (this.getClass() == b.getClass()){
            TestObject b_test = (TestObject) b;
            if (this.value<b_test.value){
                return -1;
            }
            else if(this.value==b_test.value){
                return 0;
            }
            else return 1;
         }
         else return -1;
    }

    public void Print (){
        System.out.println(value);
    }
}