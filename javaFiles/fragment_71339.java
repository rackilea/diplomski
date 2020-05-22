import java.util.ArrayList;

class A{}

public class arrlst {

    public static void main(String[] args) {
        ArrayList<ArrayList<A>> matrix = new ArrayList<ArrayList<A>>();

        matrix.add(new ArrayList<A>());
        matrix.add(new ArrayList<A>());
        matrix.add(new ArrayList<A>());

        /*matrix.get(0).set(1, new A());*/
        matrix.get(0).add(new A());

    }

}