import java.util.ArrayList;
import java.util.List;

public class SO {

    static ArrayList<Integer> specs = new ArrayList<Integer>();
    static int[] i;

    public static void main(String[] args) throws Exception {
        specs.add(5); //for(int i=0 to 5; i++)
        specs.add(7);
        specs.add(9);
        specs.add(2);
        specs.add(8);
        specs.add(9);
        i = new int[specs.size()];
        printMe(0, specs, i);
    }

    static void printMe(int depth, List<Integer> _specs, int[] i) {
        if (_specs.isEmpty()) {
            System.out.println(printI(i));
            return;
        } else {
            for (int j = 0; j < _specs.get(0); j++) {
                i[depth] = j + 1; // + 1 since you seems to want to go from 1 and not 0
                printMe(depth + 1, _specs.subList(1, _specs.size()), i);
            }
        }
    }

    static String printI(int[] i) {
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < i.length; j++) {
            sb.append(i[j]);
            if (j < i.length - 1) {
                sb.append(" ");
            }

        }
        return sb.toString();
    }
}