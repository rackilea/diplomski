public class Test {   
    static List<boolean[]> myList = new ArrayList<>();

    public static void main(String[] args){
        boolean[] arr = {true, false};
        boolean[] arr2 = {true, false};

        myList.add(arr);
        System.out.println(myList.contains(arr2)); //false
    }   
}