import java.util.ArrayList;
import java.util.List;

public class NestedList {
    public static void main(String[] args) {
        // {{1,1},2,{1,1}}
        List<Object> parent1 = new ArrayList<Object>();

        List<Object> child1 = new ArrayList<Object>();
        child1.add(1);
        child1.add(1);
        parent1.add(child1);

        parent1.add(2);

        List<Object> child3 = new ArrayList<Object>();
        child3.add(1);
        child3.add(1);
        parent1.add(child3);

        System.out.println(getSum(parent1, 1));

        // {1,{4,{6}}}
        List<Object> parent2 = new ArrayList<Object>();
        parent2.add(1);

        List<Object> child11 = new ArrayList<Object>();
        child11.add(4);

        List<Object> child111 = new ArrayList<Object>();
        child111.add(6);

        child11.add(child111);
        parent2.add(child11);
        System.out.println(getSum(parent2, 1));
    }

    private static int getSum(Object list, int depth) {
        if (list == null)
            return 0;

        int sum = 0;
        if (list.getClass() == ArrayList.class) {
            for (Object nestedList : (ArrayList<Object>) list) {
                if (nestedList.getClass() == ArrayList.class)
                    sum += getSum(nestedList, depth + 1);
                else
                    sum += getSum(nestedList, depth);
            }
        } else {
            sum += (Integer) list * depth;
            System.out.println("CurrentSum => " + sum + " integer => " + list
                    + " Depth => " + depth);
        }
        return sum;
    }
}