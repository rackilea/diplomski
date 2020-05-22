import java.util.LinkedList;
import java.util.Random;
import java.util.List;

public class Main {

    public static void main(String[] args){

        Random random = new Random();
        LinkedList<Integer> unsorted = new LinkedList<Integer>();
        for(int i = 0; i<100; i++){
            unsorted.add(random.nextInt(100));
        }

        System.out.println("unsorted: " + unsorted.toString());

        List<Integer> sorted = mergeSort(unsorted);

        System.out.println("sorted: " + sorted.toString());
    }

    //Recursive function for sorting a LinkedList
    private static LinkedList<Integer> mergeSort(LinkedList<Integer> unsorted){

        //If the list only contains 1 object it is sorted
        if(unsorted.size() == 1){
            return unsorted;
        }

        //Split the list in two parts and create a new list to store our sorted list
        LinkedList<Integer> left = mergeSort(new LinkedList<Integer>(unsorted.subList(0, unsorted.size()/2)));
        LinkedList<Integer> right = mergeSort(new LinkedList<Integer>(unsorted.subList(unsorted.size()/2, unsorted.size())));
        LinkedList<Integer> sorted = new LinkedList<Integer>();

        //Actual loop for merging the two sublists. Using LinkedLists, this is efficient. (Compared to ArrayList)
        while(!left.isEmpty() || !right.isEmpty()){
            Integer leftInt = left.peekFirst();
            Integer rightInt = right.peekFirst();

            if(!(leftInt == null) && !(rightInt == null)){
                if(leftInt < rightInt){
                    sorted.add(left.pollFirst());
                }
                else{
                    sorted.add(right.pollFirst());
                }
            }
            else if(leftInt == null){
                sorted.add(right.pollFirst());
            }
            else{
                sorted.add(left.pollFirst());
            }
        }

        return sorted;
    }
}