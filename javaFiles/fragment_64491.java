import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

class main{
    public ArrayList<Integer> nums;
    public Random generator;

    public static void main(String[] args){
        // Calling Start
        (new main()).start();
    }

    public void start(){
        nums =  nums = new ArrayList<Integer>();

        generator = new Random();

        for(int i=0;i<15;i++){
            add(generator.nextInt(20));
            print();
        }
    }

    public void add(int newNumber){
        // Check by iterating if i is already in nums
        Iterator it = nums.iterator();

        while(it.hasNext()){
            if(newNumber == (Integer) it.next())
                return;     // i is already in our list
                            // so get out add()
        }

        if(nums.size() == 10){
            int forward = nums.get(0);

            for(int i = 1; i < 10; i++){
                // Move numbers back 1 position
                nums.set(i-1,forward);
                // Save next number in forward
                forward = nums.get(i);
            }
        }

        nums.add(newNumber);
    }

    public void print(){
        String str = "";
        Iterator it = nums.iterator();

        if(it.hasNext()){
            str += "num: [ " + (Integer) it.next();
        }

        while(it.hasNext()){
            str += " , " + (Integer) it.next();
        }

        str += " ]";

        System.out.println(str);
    }
}