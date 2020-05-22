import java.util.*;
class ArrayTest{
    public static void main(String[] args) {
        // kept your code inside for loop
        ArrayList<Integer> arrList = new ArrayList<Integer>();
        for(int i =0; i<=10 ;i++){
            arrList.add(i);
        }
        System.out.println(arrList);

        Iterator itr =arrList.iterator();
        while(itr.hasNext()){
            System.out.print(itr.next()+" ");
        }
    }
}