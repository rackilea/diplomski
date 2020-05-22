import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Helper {

    public int a;
    public int b;

    public Helper(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public static void main(String[] args) {
        List<Helper> helpers = new ArrayList<Helper>();

        helpers.add(new Helper(1, 4));
        helpers.add(new Helper(1, 5));
        helpers.add(new Helper(1, 6));
        helpers.add(new Helper(2, 4));
        helpers.add(new Helper(3, 4));
        helpers.add(new Helper(2, 4));

        System.out.println(helpers);

        Collections.sort(helpers,new Comparator<Helper>(){
            public int compare(Helper h1, Helper h2){
              return (countOccurance(h1.b) > countOccurance(h2.b)) ? 1 : -1;
            }

            private int countOccurance(int b) {
                int count = 0;

                for(Helper h : helpers){
                    if(h.b == b) count++;
                }

                return count;
            }});

        System.out.println(helpers);
    }

    @Override
    public String toString() {
        return "Helper [a=" + a + ", b=" + b + "]";
    }

}