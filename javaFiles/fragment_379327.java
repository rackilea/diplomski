import static java.util.Collections.addAll;
import java.util.ArrayList;

public class TestingController {

    private static ArrayList<ArrayList<Object>> listOfLists = new ArrayList<>();

    //in the code you posted this method never gets executed
    public void resolving_requests() {

        String columns[] = {"Month, Year", "Type of risk", "Risks count", "Risks amount"};

        ArrayList<Object> singleList = new ArrayList<>();
        addAll(singleList, columns); //Adding all columns' names to the first row, simailar to foreach

        listOfLists.add(singleList);
    }

    public static ArrayList<ArrayList<Object>> get_arr_list() {
        return listOfLists; //Probably that returns empty list
    }

    public static void main(String args[]) {

        //this will print an empty list because resolving_requests was not executed
        System.out.println("listOfLists "+ TestingController.get_arr_list()) ;

        //execute resolving_requests
        new TestingController().resolving_requests();

        //now array list is not empty 
        System.out.println("listOfLists "+ TestingController.get_arr_list()) ;
    }
}