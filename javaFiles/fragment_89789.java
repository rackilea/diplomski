class Polynomial {

    private double[] coef; // declare the array as an instance member

    public Polynomial(int degree) 
    {
        coef = new double[degree]; // initialize the array in the constructor
    }

    public double[] setCoefficient(int index, double value) 
    {
        coef[index] = value; // access the array from any instance method of the class 
        return coef;
    }

}