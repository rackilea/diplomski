public class Test {
    ...
    private LinkedList<object>[] array = new LinkedList[10];
    ...
    {
        for(int i = 0; i < array.length; i++){
            array[i] = new LinkedList<hashNode>();
        }
    }
    ...
}