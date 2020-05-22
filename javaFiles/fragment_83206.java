public class GenericMethodExample {

    public static <T extends Comparable<T>> int countGreaterThan(T[] list, T element){
        int count = 0;
        for(T e:list){
            if (e.compareTo(element)>0){
                ++count;
            }
        }
        return count;
    }

    public static void main(String[] args){
        Integer[] intArray = {5 ,10,8,1,0,3};
        Integer u = new Integer(5);
        System.out.print("Number of elements are greater than "+ u.toString()+" is:");
        System.out.print(countGreaterThan(intArray,u));
    }
}