import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestSort {

    public static void main(String args[]){

        ToSort toSort1 = new ToSort(new Float(3), "3");
        ToSort toSort2 = new ToSort(new Float(6), "6");
        ToSort toSort3 = new ToSort(new Float(9), "9");
        ToSort toSort4 = new ToSort(new Float(1), "1");
        ToSort toSort5 = new ToSort(new Float(5), "5");
        ToSort toSort6 = new ToSort(new Float(0), "0");
        ToSort toSort7 = new ToSort(new Float(3), "3");
        ToSort toSort8 = new ToSort(new Float(-3), "-3");

        List<ToSort> sortList = new ArrayList<ToSort>();
        sortList.add(toSort1);
        sortList.add(toSort2);
        sortList.add(toSort3);
        sortList.add(toSort4);
        sortList.add(toSort5);
        sortList.add(toSort6);
        sortList.add(toSort7);
        sortList.add(toSort8);

        Collections.sort(sortList);

        for(ToSort toSort : sortList){
            System.out.println(toSort.toString());
        }
    }

}

public class ToSort implements Comparable<ToSort> {

    private Float val;
    private String id;

    public ToSort(Float val, String id){
        this.val = val;
        this.id = id;
    }

    @Override
    public int compareTo(ToSort f) {

        if (val.floatValue() > f.val.floatValue()) {
            return 1;
        }
        else if (val.floatValue() <  f.val.floatValue()) {
            return -1;
        }
        else {
            return 0;
        }

    }

    @Override
    public String toString(){
        return this.id;
    }
}