public class MaxHeapTest {

    @Test
    public void test() {
        MaxHeap myHeap = new MaxHeap();

        myHeap.insert(40);
        myHeap.insert(20);
        myHeap.insert(10);
        myHeap.insert(25);
        myHeap.insert(30);
        myHeap.insert(100);

        for(int i = 0; i < myHeap.current;i++){
            System.out.println(" "+myHeap.myHeap[i]);
        }
    }

}