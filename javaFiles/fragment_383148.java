public class Box<T>{
    private T t;

    public Box(T arr){this.t = arr; } // you forget this semi-colon

    public void getTheT(){
        // get the value of t at index 0
        if(t.getClass() == Integer[].class){
            System.out.println("t[0]:"+((Integer[])t)[0]); // prints 2
        }
        else
            System.out.println(t);
    }

}


public class App{
    public static void main(String[] args){
        Integer[] Arr = {2,3,4};
        Integer i1 = 3;        
        Box<Integer> i = new Box<Integer>(i1);
        i.getTheT();
        Box<Integer[]> ia = new Box<Integer[]>(Arr);
        ia.getTheT();

    }
}