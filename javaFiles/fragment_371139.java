import java.util.ArrayList;
import java.util.Random;

public class RandomNumber {

    Random random = new Random();
    int x;
    int l;
    ArrayList<Integer> arl = new ArrayList<Integer>();

    public static void main(String[] args) {
        RandomNumber r = new RandomNumber();
        r.genNumber(50,40);
        r.genNumber(50,40);
        r.genNumber(50,40);
        r.genNumber(50,40);
        r.genNumber(50,40);
        r.genNumber(50,40);
        r.genNumber(50,40);
        r.genNumber(50,40);

        //r = new RandomNumber(); // created a new one - uncommenting this line will mean the List is lost and we will generate duplicates.
        r.genNumber(50,40);
        r.genNumber(50,40);
        r.genNumber(50,40);
        r.genNumber(50,40);
        r.genNumber(50,40);
        r.genNumber(50,40);
    }

    public void genNumber(int high, int low){
        x = random.nextInt(high-low)+low;

        if(!arl.contains(x)){
            System.out.println(x);
            arl.add(x);

        }else if(arl.contains(x)){
            System.out.println("This is already in ArrayList");
        }
    }
}