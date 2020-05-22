public class Class1D {

    private int degree;
    private int [] coefficient;
    // private double evaluation=0; (Remove this!)

    public Class1D(int degree){
        this.degree =degree;
    }

    public Class1D(int degree, int[] a){

        this.degree =degree;
        this.coefficient = a.clone();
    }

    public int []getCoefficient() {
        return coefficient;  
    }

    public double Evaluathepolynomial(double value){

        // This will be the output:
        double total=0;

        // For each degree..
        for (int i =0; i<this.degree; i++)
        {

            // The current one is..
            double evaluation = Math.pow(value,i) *this.coefficient[i];

            // Add it into the total:
            // (same as total+=evaluation)
            total = total + evaluation;

        }

        // We're done! Return that total:
        return total;

    }
}