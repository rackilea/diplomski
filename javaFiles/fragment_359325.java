import org.ejml.factory.SingularMatrixException;
import org.ejml.simple.SimpleMatrix;

/**
 * Created by anquegi on 15/05/15.
 */
public class TestEjml {



    public static void main(String args[]){

        //Solving a system
        SimpleMatrix A = new SimpleMatrix(2,2);
        SimpleMatrix b = new SimpleMatrix(2,1);
        SimpleMatrix x;


        // Can assign values the usual way

        A.set(0,0,1);
        A.set(0,1,4);
        A.set(1,0,1);
        A.set(1,1,1);

        b.set(0,0,28);
        b.set(1,0,10);


        try {
            x = A.solve(b);
            System.out.println(x);
        } catch ( SingularMatrixException e ) {
            e.printStackTrace();
        }

        // So to do a Range
        SimpleMatrix my_range_v = new SimpleMatrix(10,1);

        for (int i = 0; i < my_range_v.numRows(); i++) {
            my_range_v.set(i,i); // you can set also wit set(row,col,value)
        }

        // So to do a Range
        SimpleMatrix my_range_h = new SimpleMatrix(1,10);



        for (int i = 0; i < my_range_h.numCols(); i++) {
            my_range_h.set(i,i); // you can set also wit set(row,col,value)
        }

        System.out.println(my_range_v);
        System.out.println(my_range_h);



    }

}