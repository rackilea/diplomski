package practise;

public class code{
    public static void main(String[] args){
        int[] Array = {5,8,6,4};
        int[] newArray = new int[Array.length];
        int a, b, c, d, e, f =1;

        for(int z : Array ){
            d=0;
            for(int i=0; i<Array.length; i++){
                a = z; b = Array[i];

                if( a >= b){
                    continue;}
                else{
                    d++;}
                }
            c = Math.subtractExact(Array.length , d);
            e = Math.subtractExact(c, f);
            for(int j=0; j< Array.length; j++){
                while( j == e){
                newArray[j] = z;
                break;
                }
            }

        }

        System.out.println("Here is your old Array :");
        for(int k : Array){
            System.out.println(k);

        System.out.println("Here is your new Bubble Sort Array :");
        for(int q : newArray){
            System.out.println(q);
        }

        }
    }
}