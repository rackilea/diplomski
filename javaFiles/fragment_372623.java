Object[] array = new Object[20];
int realSize = 15; // real number of items in the array

public void remove(int arrayIndex){
    array[arrayIndex] = array[realSize-1];
    realSize--;
}