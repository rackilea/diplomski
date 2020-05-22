public class TryArray {

    //array to store the students (elements)
    private Students[] arr;
    //counter of how many students are stored by this instance
    private int size;

    public void add(Students std) {
        /*
        the code here makes no sense, see explanation above
        for (int i = 0; i < arr.length ; i++) {
            arr[i] = std;
         System.out.println(std); //it willbe more than one time displayed
            break;
        }
        */
        if (size < arr.length) {
            arr[size++] = std;
            //this is for testing purposes only, in real life code
            //you shall avoid code like this here
            System.out.println(std);
        }
    }

    public TryArray(int lengthOfArray) { //Constructor for the length Array
        arr = new Students[lengthOfArray];
    }
}