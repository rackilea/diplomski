public class Test {   
    static List<MyBooleanArray> myList = new ArrayList<>();

    public static void main(String[] args){
        boolean[] arr = {true, false};
        boolean[] arr2 = {true, false};
        myList.add(new MyBooleanArray(arr));
        System.out.println(myList.contains(new MyBooleanArray(arr2))); //true
        System.out.println(myList.get(0)); //MyBooleanArray [arr=[true, false]]
    }   
}