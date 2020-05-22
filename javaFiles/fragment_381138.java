import java.util.Vector;


public class Main {


    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Vector<Integer>[] anArray = (Vector<Integer>[]) new Vector[100];
        for(int i = 0; i < anArray.length; i++)
           anArray[i] = new Vector<Integer>();
        anArray[2].add(2);//....
    }

}