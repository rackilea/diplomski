public class IntArrayList {

    int[] array = new int[10];
    int size = 0;

    public int get(int index){
        return array[index];
    }

    public void add(int value){
        if(size == array.length){
            resizeArray();
        }
        array[size] = value;
        size++;
    }

    private void resizeArray(){
        int[] newArray = new int[array.length * 2];
        for(int i=0; i<array.length; i++){
            newArray[i] = array[i];
        }
        array = newArray;
    }

    public void set(int index, int value){
        array[index] = value;
    }

    public int size(){
        return size;
    }

    public void remove(int index){
        for(int i=index; i<size-2; i++){
            array[i] = array[i+1];
        }
        size--;
    }
}