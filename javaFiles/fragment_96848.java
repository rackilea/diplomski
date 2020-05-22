import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MatrixCross {

    public static void cross(String[]... matrix){
        cross(0,matrix, Collections.EMPTY_LIST);
    }

    private static void cross(int index,String[][] matrix, List<String> result){
        if (index >= matrix.length){
            System.out.println("<test>");
            int i = 1;
            for (String str : result) {
                System.out.println(" <test_"+i+">"+str+"</test_"+i+">");
                i++;
            }
            System.out.println("</test>");
        } else {
            for (int i = 0; i < matrix[index].length; i++) {
                List<String> values = new ArrayList<>(result);
                values.add(matrix[index][i]);
                cross(index+1,matrix,values);
            }
        }
    }
    public static void main(String[] args) {
        String [] table1 = {"a", "b", "c"};
        String [] table2 = {"d"};
        String [] table3 = {"e","f"};
        cross(table1,table2,table3);
    }
}