public class A {
    /* In your code, you instantiate the array at this point, in the scope of the class, while arraySize is still uninitialized */
    String[] array; /* uninitialized, defaults to null */
    int arraySize; /* uninitialized, defaults to 0 */

    /* Simple accessor method for the array */
    public String[] getArray() {
        return array;
    }

    public int getArraySize() {
        return arraySize;
    }


    public void setArraySize(int size) {
        this.arraySize = size;
    }

    public void createArray() {
        array = new String[arraySize];
    }
}