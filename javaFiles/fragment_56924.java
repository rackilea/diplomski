/**
 * Cookbook to pass numpy arrays to Java via Jpype
 * @author Mannaggia
 */

package test.java;

public class Average2 {

public static double compute_average(double[] the_array){
    // compute the average
    double result=0;
    int i;
    for (i=0;i<the_array.length;i++){
        result=result+the_array[i];
    }
    return result/the_array.length;
}
// multiplies array by a scalar
public static double[] multiply(double[] the_array, double factor) {

    int i;
    double[] the_result= new double[the_array.length];
    for (i=0;i<the_array.length;i++) {
        the_result[i]=the_array[i]*factor;
    }
    return the_result;
}

/**
 * Matrix multiplication. 
 */
public static double[][] mult_mat(double[][] mat1, double[][] mat2){
    // find sizes
    int n1=mat1.length;
    int n2=mat2.length;
    int m1=mat1[0].length;
    int m2=mat2[0].length;
    // check that we can multiply
    if (n2 !=m1) {
        //System.err.println("Error: The number of columns of the first argument must equal the number of rows of the second");
        //return null;
        throw new IllegalArgumentException("Error: The number of columns of the first argument must equal the number of rows of the second");
    }
    // if we can, then multiply
    double[][] the_results=new double[n1][m2];
    int i,j,k;
    for (i=0;i<n1;i++){
        for (j=0;j<m2;j++){
            // initialize
            the_results[i][j]=0;
            for (k=0;k<m1;k++) {
                the_results[i][j]=the_results[i][j]+mat1[i][k]*mat2[k][j];
            }
        }
    }
    return the_results;
}

/**
 * @param args
 */
public static void main(String[] args) {
    // test case
    double an_array[]={1.0, 2.0,3.0,4.0};
    double res=Average2.compute_average(an_array);
    System.out.println("Average is =" + res);
}
}