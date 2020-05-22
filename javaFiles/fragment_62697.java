package p1;
import java.util.ArrayList;
public class A1{
    public static void main(String[] args) {
        String[][] myString = {{"A B C"}, {"D E F"}, {"G H I"}};
        DenseBoard<String> temp1 = new DenseBoard<String>(myString, "a");
        System.out.println(temp1);
    }
}

class DenseBoard <T> {
    private ArrayList<ArrayList<T>> myBoard;
    public DenseBoard(T[][] x, T fillElem){
        myBoard = new ArrayList<>();
        for(int i = 0; i < x.length; i++){
            ArrayList<T> values = new ArrayList<T>();
            for(int j = 0; j < x[i].length; j++){
                values.add(x[i][j]);
            }
            System.out.println(i);
            System.out.println(values);
            myBoard.add(values);
        }
    }
    public String toString(){
        String result = "";
        for(int i = 0; i < myBoard.size(); i++){
            for(int j = 0; j < myBoard.get(i).size(); j++){
                result += myBoard.get(i).get(j);
            }
            System.out.println();
        }
        return result;
    }
}